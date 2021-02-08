import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

/**
 * Write a description of class QuineMcCluskey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuineMcCluskey
{
	public static final int DEFAULT_TERMS_SIZE = 8;

	private int[] rawMinTerms;
	private MinTerm[] minTerms;
	private MinTerm[][] prevMinTermsByNOfOnes;
	private MinTerm[][] minTermsByNOfOnes;
	private int nVars;

    public static void main(String[] args) {
    	int i = 0;
    	int n = -1;
    	Scanner kin = new Scanner(System.in);
        kin.useLocale(Locale.US);

        int[] terms = new int[DEFAULT_TERMS_SIZE];

    	System.out.println("Introduce los valores de la tabla de verdad. 0 -> falso; 1 -> verdadero; -1 -> finalizar");
    	do {

    		System.out.printf("Término %d -> ", i);
    		n = kin.nextInt();

    		if (n < 0)
    			break;

    		/* check that we have space. If not, reallocate */
    		if (i >= terms.length) {
    			terms = Arrays.copyOf(terms, terms.length + DEFAULT_TERMS_SIZE);
    		}

    		terms[i] = n;

    		i++;
    	} while (n >= 0);

    	QuineMcCluskey qmc = new QuineMcCluskey(terms);

    	System.out.printf("La función tiene %d variables\n", qmc.getNVars());

    	System.out.println("Aquí tienes los minitérminos ordenados por cantidad de unos:");

    	qmc.printTermsByNOfOnes();

    	System.out.println("\nComencemos la primera fase del algoritmo de Quine-McCluskey...");

    	i = 0;
    	while (!qmc.isTableEmpty()) {
    		System.out.println("\nIteración: "+i);
	    	qmc.doQuineIteration();
	    	qmc.printPrevTermsByNOfOnes();
	    	i++;
    	}
    	System.out.println("");

    	System.out.println("Primera fase finalizada!");

    	System.out.println("Los implicantes primos serán:");

    	qmc.printImplicantPrimes();

    }

    /**
     * Constructor for objects of class QuineMcCluskey
     */
    public QuineMcCluskey(int[] _rawMinTerms)
    {
    	int len = _rawMinTerms.length;
    	/* Check that length of rawMinTerms is power of 2 and all terms are either 0 or 1 */

		int i;
		for (i = 0; i < len && (_rawMinTerms[i] == 0 || _rawMinTerms[i] == 1); i++);

		if (i < len) {
    		System.out.println("Error: All miniterms must be either 0 or 1 and it's size must be a power of 2");
    		return;
		}

		rawMinTerms = _rawMinTerms;

		/* Number of vars  =  log2(number_rawMinTerms) */
		nVars = (int)(Math.log(rawMinTerms.length) / Math.log(2));

		/* Count number of 1's */
		int nMinTerms = 0;
		for (i = 0; i < rawMinTerms.length; i++) {
			if (rawMinTerms[i] == 1)
				nMinTerms++;
		}

		/* Generate minTerms */
		minTerms = new MinTerm[nMinTerms];
		int j = 0;
		for (i = 0; i < minTerms.length; i++) {
			minTerms[i] = new MinTerm();
			String term = new String();
			for (; j < rawMinTerms.length; j++) {
				if (rawMinTerms[j] == 1) {
					for (int k = 0; k < nVars; k++) {
						if ((j & (1 << k)) > 0) {
							term = "1" + term;
						} else {
							term = "0" + term;
						}
					}
					j++;
					break;
				}
			}
			minTerms[i].term = term;
			minTerms[i].marked = false;
		}

		/* Now order those miniterms by number of 1's */
		minTermsByNOfOnes = new MinTerm[nVars+1][nMinTerms];

		for (i = 0; i < nVars+1; i++) {
			for (j = 0; j < minTerms.length; j++) {
				int nOnes = 0;
				for (int k = 0; k < nVars; k++) {
					if (minTerms[j].term.charAt(k) == '1')
						nOnes++;
				}

				if (nOnes == i) {
					for (int k = 0; k < minTermsByNOfOnes[i].length; k++) {
						if (minTermsByNOfOnes[i][k] == null) {
							minTermsByNOfOnes[i][k] = minTerms[j];
							break;
						}
					}
				}
			}
		}
    	
    }

    /**
     *	Does one iteration of the Quine algorithm on the table of ordered miniterms
     */
    public void doQuineIteration() {
    	MinTerm[][] newTable = new MinTerm[nVars+1][minTerms.length];
    	for (int i = 0; i < nVars; i++) {
    		for (int j = 0; minTermsByNOfOnes[i][j] != null && j < minTerms.length; j++) {
    			for (int k = 0; minTermsByNOfOnes[i+1][k] != null && k < minTerms.length; k++) {
    				/* Now we need to check that only 1 bit differs between minTermsByNOfOnes[i][j] and minTermsByNOfOnes[i+1][k] */
    				String res = new String();
    				int diffCount = 0;
    				for (int h = 0; h < nVars; h++) {
    					if (minTermsByNOfOnes[i][j].term.charAt(h) == '-' && minTermsByNOfOnes[i+1][k].term.charAt(h) == '-') {
    						res += "-";
    					} else if (minTermsByNOfOnes[i][j].term.charAt(h) == '-' && minTermsByNOfOnes[i+1][k].term.charAt(h) != '-'
    								|| minTermsByNOfOnes[i][j].term.charAt(h) != '-' && minTermsByNOfOnes[i+1][k].term.charAt(h) == '-') {
    						diffCount = -1;
    						break;
    					} else if (minTermsByNOfOnes[i][j].term.charAt(h) == '0' && minTermsByNOfOnes[i+1][k].term.charAt(h) == '0') {
    						res += "0";
    					} else if (minTermsByNOfOnes[i][j].term.charAt(h) == '1' && minTermsByNOfOnes[i+1][k].term.charAt(h) == '1') {
    						res += "1";
    					} else {
    						res += "-";
    						diffCount++;
    					}
    				}
    				if (diffCount == 1) {
    					boolean repeated = false;
    					/* Check that it's not repeated */
    					for (int h = 0; newTable[i][h] != null && h < newTable[i].length; h++) {
    						if (newTable[i][h].term.compareTo(res) == 0) {
    							repeated = true;
    						}
    					}
    					if (repeated)
    						continue;
    					/* Mark that they changed*/
    					minTermsByNOfOnes[i][j].marked = true;
    					minTermsByNOfOnes[i+1][k].marked = true;

    					/* Add the term to the new table */
    					for (int h = 0; h < newTable[i].length; h++) {
    						if (newTable[i][h] == null) {
    							newTable[i][h] = new MinTerm();
    							newTable[i][h].term = res;
    							newTable[i][h].marked = false;
    							break;
    						}
    					}
    				}
    			}
    		}
    	}

    	prevMinTermsByNOfOnes = minTermsByNOfOnes;
    	minTermsByNOfOnes = newTable;
    }

    /* Returns how many variables the function has */
    public int getNVars() { return nVars; }

   	/* Print Terms ordered by ones */
   	public void printTermsByNOfOnes() {
   		System.out.println("Número de unos\t| Términos minimales\t|");
   		for (int i = 0; i < nVars+1; i++) {
   			if (minTermsByNOfOnes[i][0] == null)
   				continue;
   			System.out.printf("%d", i);
   			for (int j = 0; minTermsByNOfOnes[i][j] != null && j < minTermsByNOfOnes[i].length; j++) {
   				System.out.printf("\t\t| %s", minTermsByNOfOnes[i][j].term);
   				if (minTermsByNOfOnes[i][j].marked) {
   					System.out.printf("*");
   				}
   				System.out.printf("\t\t\t|\n");
   			}
   			System.out.println("_________________________________________");
   		}
   	}

   	/* Print prev Terms ordered by ones */
   	public void printPrevTermsByNOfOnes() {
   		System.out.println("Número de unos\t| Términos minimales\t|");
   		for (int i = 0; i < nVars+1; i++) {
   			if (prevMinTermsByNOfOnes[i][0] == null)
   				continue;
   			System.out.printf("%d", i);
   			for (int j = 0; prevMinTermsByNOfOnes[i][j] != null && j < prevMinTermsByNOfOnes[i].length; j++) {
   				System.out.printf("\t\t| %s", prevMinTermsByNOfOnes[i][j].term);
   				if (prevMinTermsByNOfOnes[i][j].marked) {
   					System.out.printf("*");
   				}
   				System.out.printf("\t\t\t|\n");
   			}
   			System.out.println("_________________________________________");
   		}
   	}

   	/* Prints the implicant primes */
   	public void printImplicantPrimes() {
   		boolean isFirst = true;
   		for (int i = 0; i < getNVars()+1; i++) {
    		for (int j = 0; prevMinTermsByNOfOnes[i][j] != null && j < prevMinTermsByNOfOnes[i].length; j++) {
    			if (isFirst) {
    				System.out.printf("(%s)", prevMinTermsByNOfOnes[i][j].term);
    				isFirst = false;
    			} else {
    				System.out.printf(" + (%s)", prevMinTermsByNOfOnes[i][j].term);
    			}
    		}
    	}
    	System.out.print("\n");
   	}

   	/* Return if table is empty */
   	private boolean isTableEmpty() {
   		for (int i = 0; i < nVars+1; i++) {
   			if (minTermsByNOfOnes[i][0] != null)
   				return false;
   		}
   		return true;
   	}
    


}
