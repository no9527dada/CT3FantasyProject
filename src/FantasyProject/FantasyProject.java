package FantasyProject;



import FantasyProject.content.*;
import mindustry.Vars;
import mindustry.content.UnitTypes;
import mindustry.mod.Mod;


//主类
public class FantasyProject extends Mod {
    public void loadContent() {
        UnitTypes.gamma.speed = 7;
        UnitTypes.beta.speed = 5.5f;
        UnitTypes.alpha.speed = 4;
        UnitTypes.gamma.armor = 6;
        UnitTypes.beta.armor = 4;
        UnitTypes.alpha.armor = 2;
      //  资源.load();
        if(Vars.mods.locateMod("CtCoreSystem")!=null) {
            FantasyProjectContent.load();
            FantasyProjectItems.load();
            FantasyProjectGenericCrafter.load();
            FantasyProjectUnitsSuu.load();
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
        if(Vars.mods.locateMod("CtCoreSystem") ==null){
            FantasyProjectInfoDialog.show();
        }
    }
}
