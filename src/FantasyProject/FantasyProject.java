package FantasyProject;



import FantasyProject.content.*;
import arc.Events;
import arc.util.Log;
import mindustry.Vars;
import mindustry.content.UnitTypes;
import mindustry.game.EventType;
import mindustry.mod.Mod;

import static CtCoreSystem.CoreSystem.compareVersions.compareVersions;
import static FantasyProject.content.FantasyProjectWuLiu.动能卸货器;


//主类
public class FantasyProject extends Mod {
    static String  MinVersion="1.1";

    public void loadContent() {

        UnitTypes.gamma.speed = 7;
        UnitTypes.beta.speed = 5.5f;
        UnitTypes.alpha.speed = 4;
        UnitTypes.gamma.armor = 6;
        UnitTypes.beta.armor = 4;
        UnitTypes.alpha.armor = 2;
      //  资源.load();
        if((Vars.mods.locateMod("ctcoresystem")!=null) ){
            if(compareVersions(Vars.mods.getMod("ctcoresystem").meta.version, MinVersion)>=0 ) {
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
     //   FPModJS.DawnMods();
    }

 @Override
    public void init() {
    // Log.info(动能卸货器.buildType);






        if(Vars.mods.locateMod("ctcoresystem") ==null){
            FantasyProjectInfoDialog.show();
        }
    else {
        if(compareVersions( Vars.mods.getMod("ctcoresystem").meta.version , MinVersion)<0){
            FantasyProjectInfoDialog2.show();
        }
    }
}
}
