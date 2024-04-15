package AnalisisGenomico;

public class ConteoGenes {
    public static int contarGenes(String dna) {
        if (dna.length() < 3) {
            return 0;
        }

        if (dna.startsWith("ATG")) {
            int nextGene = dna.indexOf("ATG", 3);
            if (nextGene != -1) {
                return 1 + contarGenes(dna.substring(nextGene));
            } else {
                return contarGenes(dna.substring(3));
            }
        } else {
            return contarGenes(dna.substring(1));
        }
    }
}
