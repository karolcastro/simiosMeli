package com.simiosMeli.service;

import com.simiosMeli.services.DnaService;
import org.junit.Assert;
import org.junit.Test;

public class DnaServiceTest {
    private DnaService dnaService = new DnaService();

    @Test
    public void shouldReturnTrueWhenHasDnaInHorizontal() {
        String[] dna = new String[]{"CAGTAG", "TTTTAT", "GCAGGC", "ACTGAC", "TGAATC"};
        Assert.assertTrue(this.dnaService.isSimian(dnaSimios));

    }

    @Test
    public void shouldReturnTrueWhenHasDnaInVertical() {
        String[] dna = new String[]{"CAGTAG", "TATTAT", "GAAGGC", "AATGAC", "TGAATC", "TGAATC"};
        Assert.assertTrue(this.dna.isSimion(dna));
    }

    @Test
    public void shouldReturnTrueWhenHasDnaInDiagonalPrincipalParaBaixo() {
        String[] dna = new String[]{"TGTAG", "ATGGC", "GAAGA", "GGATG", "TGAAT"};
        Assert.assertTrue(this.dna.isSimion(dna));
    }

    @Test
    public void shouldReturnTrueWhenHasDnaInDiagonalPrincipalParaCima() {
        String[] dna = new String[]{"TGTGG", "ATGGG", "GGAGA", "GGATG", "TGAAT"};
        Assert.assertFalse(this.dna.isSimion(dna));
    }

    @Test
    public void shouldReturnTrueWhenHasDnaInDiagonalSecundariaParaCimaEsquerda() {
        String[] dna = new String[]{"TGTAG", "ATGTC", "GATGA", "GGATG", "TGTAT"};
        Assert.assertTrue(this.dna.isSimion(dna));
    }

    @Test
    public void shouldReturnTrueWhenHasDnaInDiagonalSecundariaParaCimaDireita() {
        String[] dna = new String[]{"TGTAG", "ATGTC", "GATGA", "GGATG", "TGTAT"};
        Assert.assertTrue(this.dna.isSimion(dna));
    }
}
