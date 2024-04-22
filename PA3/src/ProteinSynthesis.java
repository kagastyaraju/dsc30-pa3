/*
    Name: TODO
    PID:  TODO
 */


/**
 * implementation of ProteinSynthesis Class
 *
 * @author Kaushik Agastyaraju
 * @since April 20th 2024
 */
class ProteinSynthesis {
    public CharQueue transcribeDNA(String dna) {
        // checks if length is divisble by 3
        if (dna.length() % 3 != 0) {
            throw new IllegalArgumentException();
        }
        CharQueue rna = new CharQueue();
        for (int i = 0; i < dna.length(); i++) {
            char nucleotide = dna.charAt(i);
            if (nucleotide == 'T') {
                rna.enqueue('U');
            } else {
                rna.enqueue(nucleotide);
            }
        }
        return rna;
    }

    public CharQueue translateRNA(CharQueue rna) {
        //initates necessary variables for protein transcription
        CharQueue protein = new CharQueue();
        int codonLength = 0;
        char[] codon = new char[3];
        boolean startCodonFound = false;

        while (!rna.isEmpty()) {
            codon[codonLength++] = rna.dequeue();

            if (codonLength == 3) {
                String currentCodon = new String(codon);
                codonLength = 0;

                if (currentCodon.equals("AUG")) {
                    startCodonFound = true;
                }

                // looks for start codons in code

                if (startCodonFound) {
                    if (currentCodon.equals("UAA") || currentCodon.equals("UAG") || currentCodon.equals("UGA")) {
                        protein.enqueue('*');
                        break;
                    } else {
                        char aminoAcid = CodonMap.getAminoAcid(currentCodon);
                        protein.enqueue(aminoAcid);
                    }
                }
            }
        }
        if (!startCodonFound) {
            return new CharQueue();
        }
        return protein;
    }
}

