package be.vdab.mordhau.controllers;

import be.vdab.mordhau.Domain.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwordControllerTest {
    private SwordController swordController;
    @Before
    public void before(){
        swordController = new SwordController();
    }
    @Test
    public void swordsUsesTheThymeleafPage(){
        assertThat(swordController.swordBringer().getViewName()).isEqualTo("swords");
    }
    @Test
    public void swordsPassSwordsToThymeleafPage(){
        assertThat(swordController.swordBringer().getModel().get("swords") instanceof Sword[]).isTrue();
    }
    @Test
    public void swordUsesTheThymeleafPageSword(){
        assertThat(swordController.detailBringer(1).getViewName()).isEqualTo("sword");
    }
    @Test
    public void swordHasFoundSwordPassesToThymeleafPage(){
        Sword sword = (Sword) swordController.detailBringer(1).getModel().get("sword");
        assertThat(sword.getId()).isEqualTo(1);
    }
    @Test
    public void swordDoesPassUnexistingSwordToThymeleafPage(){
        assertThat(swordController.detailBringer(-1).getModel()).doesNotContainKeys("sword");
    }
}