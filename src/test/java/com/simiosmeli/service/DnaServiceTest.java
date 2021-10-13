package com.simiosmeli.service;

import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.repositories.DnaRepository;
import com.simiosmeli.services.DnaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
public class DnaServiceTest {

    @InjectMocks
    private DnaService dnaService ;

    @Test
    public void shouldReturnTrueWhenHasDnaInHorizontal() {
        String[] dnaSimios = new String[]{"CAGTAG", "TTTTAT", "GCAGGC", "ACTGAC", "TGAATC"};
        Assert.assertTrue(this.dnaService.isSimian(dnaSimios));

    }

    @Test
    public void shouldReturnTrueWhenHasDnaInVertical() {
        String[] dnaSimios = new String[]{"CAGTAG", "TATTAT", "GAAGGC", "AATGAC", "TGAATC", "TGAATC"};
        Assert.assertTrue(this.dnaService.isSimian(dnaSimios));
    }

    @Test
    public void shouldReturnTrueWhenHasDnaInDiagonalPrincipalParaBaixo() {
        String[] dnaSimios = new String[]{"TGTAG", "ATGGC", "GAAGA", "GGATG", "TGAAT"};
        Assert.assertTrue(this.dnaService.isSimian(dnaSimios));
    }

    @Test
    public void shouldReturnTrueWhenHasDnaInDiagonalPrincipalParaCima() {
        String[] dnaSimios = new String[]{"TGTGG", "ATGGG", "GGAGA", "GGATG", "TGAAT"};
        Assert.assertFalse(this.dnaService.isSimian(dnaSimios));
    }

    @Test
    public void shouldReturnTrueWhenHasDnaInDiagonalSecundariaParaCimaEsquerda() {
        String[] dnaSimios = new String[]{"TGTAG", "ATGTC", "GATGA", "GGATG", "TGTAT"};
        Assert.assertTrue(this.dnaService.isSimian(dnaSimios));
    }

    @Test
    public void shouldReturnTrueWhenHasDnaInDiagonalSecundariaParaCimaDireita() {
        String[] dnaSimios = new String[]{"TGTAG", "ATGTC", "GATGA", "GGATG", "TGTAT"};
        Assert.assertTrue(this.dnaService.isSimian(dnaSimios));
    }


}
