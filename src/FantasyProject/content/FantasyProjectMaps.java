package FantasyProject.content;

import ct.content.chapter1.Planet1;
import mindustry.type.SectorPreset;

import static FantasyProject.content.FantasyProjectPlanet.FantasyPlanet;
import static mindustry.content.Planets.serpulo;

public class FantasyProjectMaps {
    public static SectorPreset 零号, 盐碱荒滩, 冰冻森林, 生物质合成区, 陨石坑, 废墟海岸, 风吹海岛, 绵延群山, 提取前哨, 海岸线,
            海军要塞, 真菌通道, 增生区, 油田, 冲击区, 荒芜裂谷, 核矩阵, 行星发射终端,
            战役;

    public static void load() {

        零号 = new SectorPreset("CT3groundZero", FantasyPlanet, 100) {{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 50;
            difficulty = 5;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
        }};
        冰冻森林 = new SectorPreset("CT3frozenForest", FantasyPlanet, 86) {{
            captureWave = 70;
            difficulty = 5;
            addStartingItems = true;
        }};
        陨石坑 = new SectorPreset("CT3craters", FantasyPlanet, 18) {{
            captureWave = 40;
            difficulty = 5;
        }};

        生物质合成区 = new SectorPreset("CT3biomassFacility", FantasyPlanet, 81) {{
            captureWave = 80;
            difficulty = 8;
        }};
        绵延群山 = new SectorPreset("CT3stainedMountains", FantasyPlanet, 20) {{
            captureWave = 90;
            difficulty = 9;
        }};
        废墟海岸 = new SectorPreset("CT3ruinousShores", FantasyPlanet, 213) {{
            captureWave = 120;
            difficulty = 3;
        }};
        风吹海岛 = new SectorPreset("CT3windsweptIslands", FantasyPlanet, 246) {{
            captureWave = 150;
            difficulty = 10;
        }};
        海岸线 = new SectorPreset("CT3coastline", FantasyPlanet, 108) {{//边际海岸
            captureWave = 240;
            difficulty = 10;
        }};
        盐碱荒滩 = new SectorPreset("CT3saltFlats", FantasyPlanet, 101) {{
            difficulty = 7;
        }};
        提取前哨 = new SectorPreset("CT3extractionOutpost", FantasyPlanet, 165) {{
            difficulty = 9;
        }};
        海军要塞 = new SectorPreset("CT3navalFortress", FantasyPlanet, 216) {{
            difficulty = 9;
        }};
        真菌通道 = new SectorPreset("CT3fungalPass", FantasyPlanet, 21) {{
            difficulty = 9;
        }};
        增生区 = new SectorPreset("CT3overgrowth", FantasyPlanet, 134) {{
            difficulty = 9;
        }};
        冲击区 = new SectorPreset("CT3impact0078", FantasyPlanet, 227) {{
            captureWave = 121;
            difficulty = 7;
        }};
        油田 = new SectorPreset("CT3tarFields", FantasyPlanet, 23) {{
            captureWave = 131;
            difficulty = 5;
        }};
        核矩阵 = new SectorPreset("CT3nuclearComplex", FantasyPlanet, 130) {{
            captureWave = 140;
            difficulty = 9;
        }};
        荒芜裂谷 = new SectorPreset("CT3desolateRift", FantasyPlanet, 123) {{
            captureWave = 453;
            difficulty = 8;
        }};

        /*

        行星发射终端 = new SectorPreset("CT3planetaryTerminal", FantasyPlanet, 93) {{
            difficulty = 10;
            isLastSector = true;
        }};

*/


    }
}
