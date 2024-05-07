package FantasyProject;



import FantasyProject.content.*;
import mindustry.mod.Mod;


//主类
public class FantasyProject extends Mod {
    public void loadContent() {
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
