package FantasyProject.content;

import CtCoreSystem.CoreSystem.type.Ovulam5480.JumpQi;
import mindustry.content.Items;
import mindustry.world.Block;
import mindustry.world.blocks.defense.ForceProjector;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.defense.OverdriveProjector;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.units.RepairTurret;
import mindustry.world.meta.Env;


import static FantasyProject.content.FantasyProjectItems.*;
import static CtCoreSystem.CoreSystem.type.CTTechTree.addToTree;
import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;

//方块
public class FantasyProjectDefense{
    public static Block 聚能投影械, 增幅投影器, 极速投影器, 大型维修点, 跳波器,增幅修复仪, 聚能修复仪,增幅护盾仪,
                        铅墙, 大型铅墙, 硅墙, 大型硅墙, 相织硅墙, 大型相织硅墙, 钴墙, 大型钴墙,
                        钛合金墙, 大型钛合金墙, 巨型钛合金墙, 超大型钛合金墙;

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
            size = 2;
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
            requirements(defense, with(相织硅, 20, 镍板, 10));
            chanceDeflect = 10;
            flashHit = true;
            health = 3200;
            size = 2;
            envDisabled |= Env.scorching;
        }};


        // 大型相织硅墙
        大型相织硅墙 = new Wall("大型相织硅墙") {{
            //localizedName = "大型相织硅墙";
            requirements(defense, with(相织硅, 50, 镍板, 25));
            chanceDeflect = 20f;
            flashHit = true;
            health = 5500;
            size = 3;
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


        钛合金墙 = new Wall("钛合金墙") {{
            //localizedName = "钛合金墙";
            requirements(defense, with(钛合金, 10, 固体放射物, 10));
            health = 3200;
            size = 1;
            buildCostMultiplier = 5;
            envDisabled |= Env.scorching;
        }};


        大型钛合金墙 = new Wall("大型钛合金墙") {{
            //localizedName = "大型钛合金墙";
            requirements(defense, with(钛合金, 60, 固体放射物, 20));
            health = 7500;
            size = 2;
            buildCostMultiplier = 5;
            envDisabled |= Env.scorching;
        }};


        巨型钛合金墙 = new Wall("巨型钛合金墙") {{
            //localizedName = "巨型钛合金墙";
            requirements(defense, with(钛合金, 120, 固体放射物, 40));
            health = 11000;
            size = 3;
            buildCostMultiplier = 5;
            envDisabled |= Env.scorching;
        }};


        超大型钛合金墙 = new Wall("超大型钛合金墙") {{
            //localizedName = "超大型钛合金墙";
            requirements(defense, with(钛合金, 210, 固体放射物, 90, 钴, 130));
            health = 15500;
            size = 4;
            buildCostMultiplier = 5;
            envDisabled |= Env.scorching;
        }};

//功能
        跳波器=new JumpQi("跳波器"){{
            requirements(effect, with(
                    Items.copper, 15,
                    Items.lead, 20,
                    铁, 50
            ));
        }};
        大型维修点 = new RepairTurret("大型维修点") {{
            //localizedName = "大型维修点";
            repairSpeed = 1.5f;
            repairRadius = 220;
            beamWidth = 0.73f;
            powerUse = 90/60f;
            pulseRadius = 150f;
            requirements(units, with(
                    copper, 60,
                    lead, 60,
                    silicon, 35
            ));
            health = 150;
            size = 2;
        }};
        极速投影器 = new OverdriveProjector("极速投影器") {{
            //localizedName = "极速投影器";
            health = 480;
            range = 25 * 8;//范围
            phaseRangeBoost = 8 * 8f;//范围加成
            speedBoost = 2.8f;//加速
            speedBoostPhase = 1f;//加速加成
            useTime = 320;
            requirements(effect, with(
                    lead, 300,
                    titanium, 220,
                    silicon, 240,
                    plastanium, 120,
                    金, 100,
                    钴, 80,
                    相织硅, 80,
                    钻石, 30
            ));
            consumePower(2300 / 60f);
            size = 3;
            consumeItem(相织硅).boost();
        }};


        增幅投影器 = new OverdriveProjector("增幅投影器") {{
            //localizedName = "增幅投影器";
            health = 480 + 250;
            range = 33 * 8;//范围
            phaseRangeBoost = 9 * 8f;//范围加成
            speedBoost = 3;//加速
            speedBoostPhase = 1.5f;//加速加成
            useTime = 450;
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
            consumePower(7400 / 60f);
            size = 3;
            consumeItem(液电池, 5).boost();
        }};

        聚能投影械 = new OverdriveProjector("聚能投影械") {{
            //localizedName = "聚能投影械";
            health = 480 + 250 + 530;
            range = 42 * 8;//范围
            phaseRangeBoost = 13 * 8f;//范围加成
            speedBoost = 4.8f;//加速
            speedBoostPhase = 1f;//加速加成
            useTime = 450;
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
            consumePower(28000 / 60f);
            size = 5;
            consumeItem(放射混合物).boost();
        }};
        增幅修复仪 = new MendProjector("增幅修复仪") {{
            healPercent=18;
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
            consumePower(280 / 60f);
            size = 2;
            consumeItem(phaseFabric,2).boost();
        }};
        聚能修复仪 = new MendProjector("聚能修复仪") {{
            healPercent=20;
            health = 1300;
            range = 37 * 8;//范围
            phaseRangeBoost = 13 * 8f;//范围加成
            phaseBoost = 15f;
            useTime = 500;
            scaledHealth = 80;
            requirements(effect, with(
                    phaseFabric, 90,
                    titanium, 70,
                    silicon, 50,
                    plastanium, 300,
                    铁板, 160,
                    啸动合金, 30,
                    镍板, 220,
                    相织硅, 60

            ));
            consumePower(630 / 60f);
            size = 4;
            consumeItem(相织硅,5).boost();
        }};
        增幅护盾仪 = new ForceProjector("增幅护盾仪") {{
            health = 1300;
            shieldHealth = 4500;
            phaseShieldBoost = 12000 - 4500;
            radius=184;
            phaseUseTime=180;
            phaseRadiusBoost=200;
            cooldownNormal=300/60f;
            cooldownLiquid=1.4f;
            cooldownBrokenBase=0.45f;
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
            itemConsumer = consumeItem(固体放射物,2).boost();
        }};
    }
}