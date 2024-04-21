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
        // TODO
        if (dna.length() % 3 != 0);
        {
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
        // TODO
        return null;
    }

}
