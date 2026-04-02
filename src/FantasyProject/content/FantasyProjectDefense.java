package FantasyProject.content;

import CtCoreSystem.CoreSystem.type.Ovulam5480.CTOverdriveProjector;
import CtCoreSystem.CoreSystem.type.Ovulam5480.JumpQi;
import arc.Core;
import mindustry.Vars;
import mindustry.content.Items;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.units.RepairTurret;
import mindustry.world.meta.Env;
import mindustry.world.modules.ItemModule;


import static FantasyProject.content.FantasyProjectItems.*;
import static CtCoreSystem.CoreSystem.type.CTTechTree.addToTree;
import static mindustry.Vars.state;
import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;

//方块
public class FantasyProjectDefense {
    public static Block 聚能投影械, 增幅投影器, 极速投影器, 大型维修点, 跳波器, 增幅修复仪, 聚能修复仪, 增幅护盾仪,
            铅墙, 大型铅墙, 硅墙, 大型硅墙, 相织硅墙, 大型相织硅墙, 钴墙, 大型钴墙, 破墙器,钴门,
            高级塑钢墙, 大型高级塑钢墙, 钛合金墙, 大型钛合金墙, 巨型钛合金墙, 超大型钛合金墙;

    //      @Override
//            public boolean canReplace(Block other) {
//                return true;
//            }//解除方块限制
    public static void load() {


        // 铅墙
        铅墙 = new Wall("铅墙") {{
            //localizedName = "铅墙";
            requirements(defense, with(lead, 4));
            health = 320;
            size = 1;
            envDisabled |= Env.scorching;
        }};

        // 大型铅墙
        大型铅墙 = new Wall("大型铅墙") {{
            //localizedName = "大型铅墙";
            requirements(defense, with(lead, 24));
            health = 1300;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 硅墙
        硅墙 = new Wall("硅墙") {{
            //localizedName = "硅墙";
            requirements(defense, with(silicon, 4));
            chanceDeflect = 3f;
            flashHit = true;
            health = 550;
            size = 1;
            envDisabled |= Env.scorching;
        }};


        // 大型硅墙
        大型硅墙 = new Wall("大型硅墙") {{
            //localizedName = "大型硅墙";
            requirements(defense, with(silicon, 24));
            chanceDeflect = 5f;
            flashHit = true;
            health = 2200;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 相织硅墙
        相织硅墙 = new Wall("相织硅墙") {{
            //localizedName = "相织硅墙";
            requirements(defense, with(相织硅, 5, 镍板, 10));
            chanceDeflect = 10;
            flashHit = true;
            health = 3200;
            size = 1;
            envDisabled |= Env.scorching;
        }};


        // 大型相织硅墙
        大型相织硅墙 = new Wall("大型相织硅墙") {{
            //localizedName = "大型相织硅墙";
            requirements(defense, with(相织硅, 15, 镍板, 25));
            chanceDeflect = 20f;
            flashHit = true;
            health = 5500;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 钴墙
        钴墙 = new Wall("钴墙") {{
            //localizedName = "钴墙";
            requirements(defense, with(钴, 30));
            lightningChance = 0.1f;
            lightningDamage = 15;
            lightningLength = 10;
            health = 1500;
            size = 1;
            buildCostMultiplier = 5;
            envDisabled |= Env.scorching;
        }};


        // 大型钴墙
        大型钴墙 = new Wall("大型钴墙") {{
            //localizedName = "大型钴墙";
            requirements(defense, with(钴, 70));
            lightningChance = 0.1f;
            lightningDamage = 20;
            lightningLength = 15;
            health = 5300;
            size = 2;
            buildCostMultiplier = 7;
            envDisabled |= Env.scorching;
        }};
        高级塑钢墙 = new Wall("高级塑钢墙") {{
            //localizedName = "大型钴墙";
            requirements(defense, with(塑钢, 50, 钛合金, 30));
            lightningChance = 0.1f;
            lightningDamage = 20;
            lightningLength = 15;
            insulated = false;//电力隔离
            absorbLasers = true;//  吸收激光
            health = 4200;
            size = 2;
            buildCostMultiplier = 3;
            envDisabled |= Env.scorching;
        }};
        大型高级塑钢墙 = new Wall("大型高级塑钢墙") {{
            //localizedName = "大型钴墙";
            requirements(defense, with(镍板, 30, 塑钢, 100, 钛合金, 60));
            lightningChance = 0.1f;
            lightningDamage = 20;
            lightningLength = 15;
            insulated = false;//电力隔离
            absorbLasers = true;//  吸收激光
            health = 8000;
            size = 3;
            buildCostMultiplier = 3;
            envDisabled |= Env.scorching;
        }};

        钛合金墙 = new Wall("钛合金墙") {{
            //localizedName = "钛合金墙";
            requirements(defense, with(钛合金, 10, 固体放射物, 10));
            health = 3200;
            size = 1;
            buildTime = 3f*10;
            // buildCostMultiplier = 3;
            envDisabled |= Env.scorching;
        }};


        大型钛合金墙 = new Wall("大型钛合金墙") {{
            //localizedName = "大型钛合金墙";
            requirements(defense, with(钛合金, 20, 固体放射物, 20,钴, 50));
            health = 7500;
            size = 2;
            buildTime = 7f*10;
            // buildCostMultiplier = 3;
            envDisabled |= Env.scorching;
        }};


        巨型钛合金墙 = new Wall("巨型钛合金墙") {{
            //localizedName = "巨型钛合金墙";
            requirements(defense, with(钛合金, 40, 固体放射物, 30,镍板,15,钴, 130));
            health = 11000;
            size = 3;
            buildTime = 13f*10;//建造时间 13秒
            // buildCostMultiplier = 3;
            envDisabled |= Env.scorching;
        }};


        超大型钛合金墙 = new Wall("超大型钛合金墙") {{
            //localizedName = "超大型钛合金墙";
            requirements(defense, with(钛合金, 90, 固体放射物, 50,镍板,40, 啸动合金,5,钴, 200));
            health = 15500;
            size = 4;
            buildTime = 20f*10;
           // buildCostMultiplier = 3;
            envDisabled |= Env.scorching;
        }};

//功能
        破墙器 = new Wall("破墙器") {
/*            @Override
            public void beforePlaceBegan(Tile tile, Block previous){
                if(tile.build instanceof CoreBlock.CoreBuild){
                    //right before placing, create a "destination" item array which is all the previous items minus core requirements
                    ItemModule items = tile.build.items.copy();
                    if(!state.rules.infiniteResources){
                        items.remove(ItemStack.mult(requirements, state.rules.buildCostMultiplier));
                    }

                }
            }*/
            @Override
            public boolean canPlaceOn(Tile tile, Team team, int rotation){
                CoreBlock.CoreBuild core = team.core();
                if(core == null || (!state.rules.infiniteResources && !core.items.has(requirements, state.rules.buildCostMultiplier))) return false;

                return super.canPlaceOn(tile, team, rotation);
            }
            //显示红字
            @Override
            public void drawPlace(int x, int y, int rotation, boolean valid) {
                CoreBlock.CoreBuild core = Vars.player.team().core();
                if (!Vars.state.rules.infiniteResources && !core.items.has(requirements, Vars.state.rules.buildCostMultiplier)) {
                    drawPlaceText(Core.bundle.format("bar.noresources"), x, y, valid);
                }
                super.drawPlace(x, y, rotation, valid);
            }
            @Override
            public boolean canReplace(Block other) {
                return !other.privileged;
            }//解除方块限制

            //生存模式不可拆
            @Override
            public boolean canBreak(Tile tile) {
                return state.rules.editor || Vars.state.rules.infiniteResources || state.playtestingMap != null;
            }
            class Build extends WallBuild {
                @Override
                public void updateTile() {
                    if (timer().get(120)) {
                        damage(34);
                      //  damage(34 * maxHealth / 100);
                    }
                }
            }
            {
                requirements(effect, with(啸动合金, 20, 爆破弹, 3000));
                health = 100;
                size = 1;
                update = true;
                rebuildable = false;//不会自动重建
                envDisabled |= Env.scorching;
                placeableLiquid = true;
                buildCostMultiplier = 0;
               buildType = Build::new;
            }
        };
        钴门 = new Door("钴门") {{
            //localizedName = "钛合金墙";
            requirements(defense, with(钴, 50, 硅, 100));
            health = 4000;
            size = 3;
            buildCostMultiplier = 4;
            envDisabled |= Env.scorching;
            placeableLiquid = true;//可被放在深水之上
        }};
        跳波器 = new JumpQi("跳波器") {{
            requirements(effect, with(
                    Items.copper, 15,
                    Items.lead, 20,
                    铁, 50
            ));
        }};
        大型维修点 = new RepairTurret("大型维修点") {{
            //localizedName = "大型维修点";
            repairSpeed = 2f;//治疗量 1:60
            repairRadius = 62f*8;//范围
            beamWidth = 0.73f;
            powerUse = 150 / 60f;//耗电
            pulseRadius = 150f;
            requirements(units, with(
                    copper, 60,
                    lead, 60,
                    silicon, 35,
                    金,30
            ));
            health = 150;
            size = 2;
        }};
        极速投影器 = new CTOverdriveProjector("极速投影器") {{
            //localizedName = "极速投影器";
            health = 480;
            range = 25 * 8;//范围
            phaseRangeBoost = 8 * 8f;//范围加成
            speedBoost = 2.8f;//加速
            speedBoostPhase = 1f;//加速加成
            useTime = 320;

            requirements(effect, with(
                    铁, 220,
                    titanium, 150,
                    silicon, 140,
                    布, 80,
                    金, 180,
                    钴, 280,
                    钛合金, 100
            ));
            consumePower(2300 / 60f);
            size = 3;
            consumeItem(相织硅).boost();
        }};


        增幅投影器 = new CTOverdriveProjector("增幅投影器") {{
            //localizedName = "增幅投影器";
            health = 480 + 250;
            range = 33 * 8;//范围
            phaseRangeBoost = 9 * 8f;//范围加成
            speedBoost = 3;//加速
            speedBoostPhase = 1.5f;//加速加成
            useTime = 300;
            requirements(effect, with(
                    铁板, 40,
                    titanium, 220,
                    silicon, 240,
                    plastanium, 120,
                    金, 130,
                    钛合金, 80,
                    相织硅, 70,
                    钻石, 50
            ));
            itemCapacity = 20;
            consumePower(7400 / 60f);
            size = 3;
            consumeItem(液电池, 1).boost();
        }};

        聚能投影械 = new CTOverdriveProjector("聚能投影械") {{
            //localizedName = "聚能投影械";
            health = 480 + 250 + 530;
            range = 55 * 8;//范围
            phaseRangeBoost = 245 * 8f;//范围加成
            speedBoost = 4.8f;//加速
            speedBoostPhase = 1f;//加速加成
            useTime = 60*60*3;//3分钟消耗一个水晶
            requirements(effect, with(
                    lead, 300,
                    titanium, 220,
                    silicon, 240,
                    plastanium, 120,
                    啸动合金, 75,
                    镍板, 80,
                    相织硅, 280,
                    钻石, 130
            ));
            consumePower(48000 / 60f);
            size = 5;
            consumeItem(黎辉水晶).boost();
        }};
        增幅修复仪 = new MendProjector("增幅修复仪") {{
            healPercent = 18;
            health = 600;
            range = 20 * 8;//范围
            phaseRangeBoost = 8 * 8f;//范围加成
            phaseBoost = 15f;
            useTime = 400;
            scaledHealth = 80;
            requirements(effect, with(
                    phaseFabric, 90,
                    titanium, 130,
                    silicon, 100,
                    plastanium, 80,
                    铁, 60

            ));
            itemCapacity = 20;
            consumePower(560 / 60f);
            size = 2;
            consumeItem(phaseFabric, 2).boost();
        }};
        聚能修复仪 = new MendProjector("聚能修复仪") {{
            healPercent = 20;
            health = 1300;
            range = 47 * 8;//范围
            phaseRangeBoost = (62 - 47) * 8f;//范围加成
            phaseBoost = 15f;
            useTime = 500;
            scaledHealth = 80;
            itemCapacity = 20;
            requirements(effect, with(
                    phaseFabric, 90,
                    titanium, 70,
                    silicon, 50,
                    plastanium, 300,
                    铁板, 160,
                    啸动合金, 5,
                    镍板, 220,
                    相织硅, 60

            ));
            consumePower(1200 / 60f);
            size = 4;
            consumeItem(相织硅, 2).boost();
        }};
        增幅护盾仪 = new ForceProjector("增幅护盾仪") {{
            health = 1300;
            shieldHealth = 13000;
            phaseShieldBoost = 25000 - 13000;
            radius = 184;
            phaseUseTime = 30 * 60;
            phaseRadiusBoost = 200;
            cooldownNormal = 500 / 60f;
            cooldownLiquid = 1.4f;
            cooldownBrokenBase = 0.45f;
            //scaledHealth = 80;
            requirements(effect, with(
                    phaseFabric, 90,
                    钍, 180,
                    silicon, 150,
                    plastanium, 75,
                    铁板, 60,
                    相织硅, 60

            ));
            consumePower(2400 / 60f);
            size = 4;
            itemConsumer = consumeItem(放射混合物, 1).boost();
        }};
    }
}