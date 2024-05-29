package FantasyProject;



import FantasyProject.content.*;
import mindustry.Vars;
import mindustry.mod.Mod;


//主类
public class FantasyProject extends Mod {
    public void loadContent() {
        if(/*Vars.mods.getMod("ct")!=null||*/Vars.mods.locateMod("ct") !=null) {
            FantasyProjectContent.load();
            FantasyProjectItems.load();
            FantasyProjectGenericCrafter.load();
            FantasyProjectUnits.load();
            FantasyProjectDrill.load();
            FantasyProjectDefense.load();
            FantasyProjectTurrets.load();
            FantasyProjectPower.load();
            FantasyProjectWuLiu.load();
            FantasyProjectPlanet.load();
            FantasyProjectMaps.load();
            FantasyProjectTechTree.load();
        }
    }
    @Override
    public void init() {
        if(Vars.mods.locateMod("ct") ==null){
            FantasyProjectInfoDialog.show();
        }
    }
}
