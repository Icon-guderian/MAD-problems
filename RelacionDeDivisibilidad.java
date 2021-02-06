import java.util.Arrays;
/**
 * Write a description of class RelacionDeDivisibilidad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RelacionDeDivisibilidad
{
	// CONSTANTS
	public final int ERR_OOB = -1;
	public final int ERR_NOT_FOUND = -2;
    // instance variables - replace the example below with your own
    private int[] set;

    /**
     * Constructor for objects of class RelacionDeDivisibilidad
     */
    public RelacionDeDivisibilidad(int size)
    {
        set = new int[size];
        for (int i = 1; i <= size; i++) {
        	set[i-1] = i;
        }
    }

    public RelacionDeDivisibilidad(int[] _set) {
    	set = _set;
    	/* Let's sort the set */
    	Arrays.sort(set);
    }

    /**
     * Toma 2 enteros que representan un índice del conjunto y calcula su supremo.
     */
    public int supremoIdx(int a, int b) {
    	/* Check is on range */
    	if (a >= set.length || b >= set.length) {
    		return ERR_OOB; /* OUT-OF-BOUNDS */
    	}
    	int maxN = Math.max(a, b);

    	for (int i = maxN; i < set.length; i++) {
    		if (set[i] % set[a] == 0 && set[i] % set[b] == 0) {
    			return i;
    		}
    	}

    	return ERR_NOT_FOUND; /* NOT FOUND*/
    }

    /**
     * Toma 2 enteros que pertenecen al conjunto y calcula su supremo
     */
    public int supremoVal(int a, int b) {
    	/* Calculate the index of the values */
    	int idxa = indexOf(a);
    	int idxb = indexOf(b);
    	return set[supremoIdx(idxa, idxb)];
    }

    /**
     * Toma 2 enteros que representan un índice del conjunto y calcula su ínfimo.
     */
    public int infimoIdx(int a, int b) {
    	/* Check is on range */
    	if (a >= set.length || b >= set.length) {
    		return ERR_OOB; /* OUT-OF-BOUNDS */
    	}
    	int minN = Math.min(a, b);

    	for (int i = minN; i >= 0; i--) {
    		if (set[a] % set[i] == 0 && set[b] % set[i] == 0) {
    			return i;
    		}
    	}

    	return ERR_NOT_FOUND;
    }

    /**
     * Toma 2 enteros que pertenecen al conjunto y calcula su supremo
     */
    public int infimoVal(int a, int b) {
    	/* Calculate the index of the values */
    	int idxa = indexOf(a);
    	int idxb = indexOf(b);
    	return set[infimoIdx(idxa, idxb)];
    }

    /**
     * Calcula el índice del máximo del conjunto (si existe). No toma parámetros
     */
    public int maximoIdx() {
    	/* Para ello comprobaremos que el supremo entre cualquier elemento del conjunto y el último elemento siempre es el último elemento */
    	for (int i = 0; i < set.length-1; i++) {
    		if (supremoIdx(i, set.length-1) != set.length-1) {
    			return ERR_NOT_FOUND; /* This set doesn't have a maximum */
    		}
    	}
    	return set.length-1; /* Set is always in order */ 
    }
    /**
     * Calcula el máximo del conjunto (si existe). No toma parámetros
     */
    public int maximoVal() {
    	int idx = maximoIdx();
    	if (idx < 0)	/* Check that no error was returned */
    		return idx;
    	return set[idx];
    }

    /**
     * Calcula el índice del mínimo del conjunto (si existe). No toma parámetros
     */
    public int minimoIdx() {
    	/* Para ello comprobaremos que el infimo entre cualquier elemento del conjunto y el primer elemento siempre es el primer elemento */
    	for (int i = 1; i < set.length; i++) {
    		if (infimoIdx(0, i) != 0) {
    			return ERR_NOT_FOUND;
    		}
    	}
    	return 0;
    }

    /**
     * Calcula el mínimo del conjunto (si existe). No toma parámetros
     */
    public int minimoVal() {
    	int idx = minimoIdx();
    	if (idx < 0)	/* Check that no error was returned */
    		return idx;
    	return set[idx];
    }

    /**
     *	Devuelve el conjunto de los índices de los maximales del conjunto
     */
    public int[] maximalesIdx() {
    	int[] res = new int[set.length];
    	/* Initialize array to -1 for detecting empty entries */
    	for (int i = 0; i < res.length; i++) {
    		res[i] = -1;
    	}
    	for (int i = 0; i < set.length-1; i++) {
    		int j;
    		for (j = i+1; j < set.length; j++) {
    			if (set[j] % set[i] == 0)
    				break;
    		}
    		if (j == set.length) {
    			/* Add maximal to result set */
    			for (int k = 0; k < res.length; k++) {
    				if (res[k] == -1) {
    					res[k] = i;
    					break;
    				}
    			}
    		}
    	}
    	/* Remember always adding last element */
    	for (int i = 0; i < res.length; i++) {
    		if (res[i] == -1) {
    			res[i] = set.length-1;
    			break;
    		}
    	}
    	return res;
    }

    public int[] maximalesVal() {
    	int[] indxs = maximalesIdx();
    	int[] res = new int[indxs.length];
    	for (int i = 0; i < indxs.length && indxs[i] >= 0; i++) {
    		res[i] = set[indxs[i]];
    	}
    	return res;
    }

    /**
     * Calcula el conjunto de las cotas superiores del subconjunto "a" en el objecto.
     */
    public int[] cotasSuperiores(int[] a) {
    	int[] upperBound = new int[set.length];

    	/* Initialize array to -1 so we can detect empty spaces */
    	for (int i = 0; i < upperBound.length; i++) {
    		upperBound[i] = -1;
    	}
    	Arrays.sort(a); /* First of all lets sort the array so we can asume that a(n-1) < a(n) */

    	/* Now let's look for upper bounds */
    	for (int i = indexOf(a[a.length-1]); i < set.length; i++) {
    		int j;
    		for (j = 0; j < a.length; j++) {
    			if (set[i] % a[j] != 0)
    				break;
    		}
    		if (j == a.length) {
    			for (int k = 0; k < upperBound.length; k++) {
    				if (upperBound[k] == -1) {
    					upperBound[k] = set[i];
    					break;
    				}
    			}
    		}
    	}
    	return upperBound;
    }

    public int[] cotasInferiores(int[] a) {
    	int[] lowerBound = new int[set.length];

    	/* Initialize array to -1 so we can detect empty spaces */
    	for (int i = 0; i < lowerBound.length; i++) {
    		lowerBound[i] = -1;
    	}
    	Arrays.sort(a); /* First of all lets sort the array so we can asume that a(n-1) < a(n) */

    	/* Now let's look for lower bounds */
    	for (int i = indexOf(a[0]); i >= 0; i--) {
    		int j;
    		for (j = 0; j < a.length; j++) {
    			if (a[j] % set[i] != 0)
    				break;
    		}
    		if (j == a.length) {
    			for (int k = 0; k < lowerBound.length; k++) {
    				if (lowerBound[k] == -1) {
    					lowerBound[k] = set[i];
    					break;
    				}
    			}
    		}
    	}
    	return lowerBound;
    }

    /**
     * Calcula si el conjunto es un retículo.
     */
    public boolean esReticulo() {
    	for (int i = 0; i < set.length; i++) {
    		for(int j = 0; j < set.length; j++) {
    			int[] subconj = new int[2];
    			subconj[0] = set[i];
    			subconj[1] = set[j];
    			int[] cotasup = cotasSuperiores(subconj);
    			int[] cotainf = cotasInferiores(subconj);

    			if (cotasup.length < 1 || cotainf.length < 1) {
					return false;    				
    			} 
    		}
    	}
    	return true;
    }

    /**
     * Calcula si el conjunto es un retículo de boole
     */
    public boolean esReticuloDeBoole() {
    	if (esReticuloComplementado() && esReticuloDistributivo()) {
    		return true;
    	}
    	return false;    	
    }

    /**
     * Comprueba si es un retículo distributivo
     */
    public boolean esReticuloDistributivo() {
    	if (!esReticulo())
    		return false;
    	for (int i = 0; i < set.length-2; i++) {
    		for (int j = i+1; j < set.length-1; j++) {
    			for (int k = j+1; k < set.length; k++) {
    				if (supremoIdx(i, infimoIdx(j, k)) != infimoIdx(supremoIdx(i, j), supremoIdx(i, k)))
    					return false;
    			}
    		}
    	}
    	return true;
    }

	/**
	 * Comprueba si se trata de un conjunto complementado.
	 */
	public boolean esReticuloComplementado() {
		if (!esReticulo()) {
    		return false;
    	}
    	for (int i = 0; i < set.length; i++) {
    		if (complement(set[i]) < 0)
    			return false;
    	}
    	return true;

	}

    /**
     * Calcula el complementario de a en el conjunto
     */
    public int complement(int a) {
    	/* Check that a exists in 'set' */
    	int idx;
    	for (idx = 0; idx < set.length; idx++) {
    		if (a == set[idx]) {
    			break;
    		}
    	}
    	if (idx == set.length)
    		return ERR_NOT_FOUND;

    	/* The complement of a is such that a^b = 0 && avb = 1 */
    	for (int i = 0; i < set.length; i++) {
    		if (i == idx)
    			continue;
    		if (supremoIdx(idx, i) == set.length-1 && infimoIdx(idx, i) == 0) {
    			return set[i];
    		}
    	}

    	return ERR_NOT_FOUND;

    }

    /**
     * Calcula el índice de un valor dado
     */
    private int indexOf(int a) {
    	int idxa = -1;
    	for (int i = 0; i < set.length; i++) {
    		if (set[i] == a) {
    			idxa = i;
    		}
    		if (idxa > 0) {
    			break;
    		}
    	}
    	if (idxa < 0) {
    		return ERR_NOT_FOUND;
    	}
    	return idxa;
    }
}
