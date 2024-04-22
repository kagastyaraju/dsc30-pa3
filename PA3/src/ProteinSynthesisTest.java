import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {

    @Test
    void transcribeDNA() {
        ProteinSynthesis proteinSynthesis = new ProteinSynthesis();
        String dna = "ATGCGTACTGAC";
        CharQueue rna = proteinSynthesis.transcribeDNA(dna);
        assertEquals(dna.length(), rna.size());

        StringBuilder transcribed = new StringBuilder();
        while (!rna.isEmpty()) {
            transcribed.append(rna.dequeue());
        }
        String expectedRNA = "AUGCGUACUGAC";
        assertEquals(expectedRNA, transcribed.toString());
    }

    @Test
    void secondtranscribeDNA() {
        ProteinSynthesis proteinSynthesis = new ProteinSynthesis();
        String dna = "CTGAGCCTGGACTCAACCGGTTGCTGGGTGAACTCCAGACTCGGGGCGACAACTCTTCATACATAGAGCAAGGGCGTCGAACGGTCGTGA";
        CharQueue rna = proteinSynthesis.transcribeDNA(dna);
        assertEquals(dna.length(), rna.size());

        StringBuilder transcribed = new StringBuilder();
        while (!rna.isEmpty()) {
            transcribed.append(rna.dequeue());
        }
        String expectedRNA = "CUGAGCCUGGACUCAACCGGUUGCUGGGUGAACUCCAGACUCGGGGCGACAACUCUUCAUACAUAGAGCAAGGGCGUCGAACGGUCGUGA";
        assertEquals(expectedRNA, transcribed.toString());
    }


    @Test
    void translateRNA() {

        CharQueue rna = new CharQueue();
        String rnaSequence = "AUGGCUUGA";
        for (char nucleotide : rnaSequence.toCharArray()) {
            rna.enqueue(nucleotide);
        }

        ProteinSynthesis proteinSynthesis = new ProteinSynthesis();
        CharQueue protein = proteinSynthesis.translateRNA(rna);

        assertNotNull(protein);
        assertFalse(protein.isEmpty());
        StringBuilder proteinSequence = new StringBuilder();
        while (!protein.isEmpty()) {
            proteinSequence.append(protein.dequeue());
        }
        assertEquals("MA*", proteinSequence.toString());
    }
    }
