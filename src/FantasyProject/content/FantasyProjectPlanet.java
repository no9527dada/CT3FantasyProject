package FantasyProject.content;

import arc.Core;
import arc.graphics.Color;
import arc.struct.ObjectSet;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Planet;
import mindustry.type.Sector;

import static FantasyProject.content.FantasyProjectItems.mod资源5显示;
import static mindustry.content.Blocks.*;


public class FantasyProjectPlanet {
    public static Planet
            FantasyPlanet;

    /*    public static Block
                coreT1,coreT2,coreT3;*/
    public static void load() {

        FantasyPlanet = new Planet("FantasyPlanet", Planets.sun, 1f, 3) {{
            localizedName = Core.bundle.format("FantasyPlanet");
            generator = new SerpuloPlanetGenerator() {
                public boolean allowLanding(Sector sector) {
                    return false;
                }//关闭数字区块

                public void generateSector(Sector sector) {

                }//无基地

            };
            // defaultEnv = Env.terrestrial;//*这个星球上扇区的环境标志。

            iconColor = Color.valueOf("ee7433");
            atmosphereColor = Color.valueOf("ee7433");
            landCloudColor = Pal.spore.cpy().a(0.5f);
            meshLoader = () -> new HexMesh(this, 7);
            itemWhitelist.addAll(mod资源5显示);
            bloom = true;
            startSector = 100;
            alwaysUnlocked = true;
            clearSectorOnLose = true;//扇区丢失时是否重置地图
            enemyCoreSpawnReplace = false;//攻击图核心变刷怪点
            allowLaunchSchematics = false;//开启发射核心蓝图
            allowLaunchLoadout = false;//开启携带资源发射
            allowSectorInvasion = false;//模拟攻击图入侵
            allowWaveSimulation = false;//模拟后台波次
            accessible = true;
            //TODO SHOULD there be lighting?
            updateLighting = true;//模拟白天黑夜  开启星球自转
            ruleSetter = r -> {
                r.bannedBlocks.addAll(//禁用方块
                        groundFactory,
                        airFactory,
                        navalFactory,
                        additiveReconstructor,
                        multiplicativeReconstructor,
                        exponentialReconstructor,
                        payloadConveyor,
                        payloadRouter,
                        tetrativeReconstructor);
                r.unitAmmo = true;//单位需要子弹
                r.showSpawns = true;//显示单位刷出点
                r.unitCapVariable=false;//核心增加单位上限
                r.unitCap = 9999;//单位上限
                //r.onlyDepositCore = true;//物品只能存放在核心
                r.coreDestroyClear = true;//死亡时(敌人)核心半径内的每个敌人方块都会被摧毁。
                r.teams.get(Team.sharded).unitHealthMultiplier = 1.8f;//己方单位血量
                r.teams.get(Team.crux).unitDamageMultiplier = 1.2f;//敌人单位伤害
                r.teams.get(Team.crux).blockDamageMultiplier = 1.5f;//敌人建筑伤害
                r.waveTeam = Team.crux;
                r.fog = false;//迷雾
                r.placeRangeCheck = false;


            };
            unlockedOnLand.add(Blocks.coreShard);
        }};

        //  setPlanet(Planet5, new String[]{"ct"});


    }

}
