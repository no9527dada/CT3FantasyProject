package FantasyProject.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.world.Block;
import mindustry.world.blocks.power.*;
import mindustry.world.consumers.ConsumeItemExplode;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.consumers.ConsumeItemRadioactive;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;

import static FantasyProject.content.FantasyProjectItems.*;
import static ct.Asystem.type.CTTechTree.addToTree;
import static mindustry.content.Liquids.oil;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.type.Category.*;
import static mindustry.type.ItemStack.with;

public class FantasyProjectPower {
    public static Block
            离心发电机, 汽轮发电机, 超级rtg发电机,
            石油冲击发电机, 相对发电机, 核反应堆, 火能发电机, 充能水晶, 超大型电池, 连接终端, 超大型能量塔, 充能节点, 超大型太阳能板, 电力, 地水发电机, 地水触及机, 地引发电机, 低压太阳发电机, 中压太阳发电机, 高压太阳发电机;

    public static void load() {
        连接终端 = new PowerNode("连接终端") {{
            //localizedName = "连接终端";
            requirements(power, with(
                    lead, 220,
                    thorium, 120,
                    镍板, 100,
                    钴, 50,
                    铁板, 30
            ));
            laserRange = 500;
            maxNodes = 2;
            health = 750;
            size = 3;
            consumePowerBuffered(70000);

            laserScale = 0.25f;
            laserColor1 = Color.white;
            laserColor2 = Color.valueOf("b17bff");

        }};


        充能节点 = new PowerNode("充能节点") {{
            //localizedName = "水晶能量节点";
            requirements(power, with(
                    metaglass, 800,
                    silicon, 500,
                    黎辉水晶, 50
            ));
            consumePowerBuffered(2000000);
            laserRange = 300;
            maxNodes = 5000;
            health = 500;
            size = 3;
            laserScale = 0.25f;
            laserColor1 = Color.white;
            laserColor2 = Color.valueOf("b17bff");

        }};


        火能发电机 = new ConsumeGenerator("火能发电机") {{
            //localizedName = "火能发电机";
            requirements(power, with(
                    lead, 40,
                    copper, 40,
                    silicon, 20
                    //碳板,5
            ));
            size = 2;
            powerProduction = 220 / 60f;
            itemDuration = 150;
            itemCapacity = 15;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;
            health = 140;
            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());

            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion());
        }};

        汽轮发电机 = new ConsumeGenerator("汽轮发电机") {{
            //localizedName = "汽轮发电机";
            requirements(power, with(
                    lead, 70,
                    copper, 80,
                    铁, 90,
                    silicon, 120
            ));
            size = 2;
            powerProduction = 650 / 60f;
            itemDuration = 90;
            itemCapacity = 10;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;
            health = 170;
            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());
            consumeLiquid(Liquids.water, 6 / 60f).update(false);
            drawer = new DrawMulti( new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawDefault(),
                    new DrawWarmupRegion());
        }};


        离心发电机 = new ConsumeGenerator("离心发电机") {{
            //localizedName = "离心发电机";
            requirements(power, with(
                    钴, 250,
                    金, 80,
                    相织硅, 50,
                    镍板, 30
            ));
            size = 3;
            powerProduction = 4500 / 60f;
            itemDuration = 240;
            itemCapacity = 3;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;
            health = 170;
            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());
            consumeLiquid(Liquids.water, 12 / 60f).update(false);
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),//黑底
                    new DrawLiquidTile(Liquids.water),
                    new DrawDefault(),
                    new DrawWarmupRegion(){{color = Color.valueOf("ffd9d9");}},//颜色一闪一闪的
                    new DrawRegion("-turbine") {{//转转
                        rotateSpeed = 2f;
                    }});
        }};



        超大型电池 = new Battery("超大型电池") {{
            //localizedName = "超大型电池";
            requirements(power, with(
                    lead, 250,
                    silicon, 125,
                    石英, 750,
                    石英, 300,
                    金, 55,
                    钻石, 10
            ));
            consumePowerBuffered(100000);
            health = 500;
            size = 4;
            buildCostMultiplier = 0.4f;
            emptyLightColor = Color.valueOf("f8c26600");
            fullLightColor = Color.valueOf("ffffff");
        }};


        充能水晶 = new Battery("充能水晶") {{
            //localizedName = "充能水晶电池";
            requirements(power, with(
                    lead, 420,
                    silicon, 500,
                    黎辉水晶, 50,
                    钻石, 300
            ));
            consumePowerBuffered(5000000);
            health = 1200;
            size = 3;
            buildCostMultiplier = 0.4f;
            emptyLightColor = Color.valueOf("f8c26600");
            fullLightColor = Color.valueOf("ffffff");

        }};

/*
        超大型能量塔 = new PowerNode("超大型能量塔") {{
            //localizedName = "超大型能量塔";
            requirements(power, with(
                    copper, 100,
                    lead, 100,
                    graphite, 100,
                    thorium, 100,
                    surgeAlloy, 100,
                    钴, 500,
                    钻石, 1
            ));
            consumePowerBuffered(70000);
            laserRange = 60;
            maxNodes = 10;
            health = 350;
            size = 3;
        }};
      addToTree(超大型能量塔, surgeTower);*/


        超大型太阳能板 = new SolarGenerator("超大型太阳能板") {{
            //localizedName = "超大型太阳能板";
            requirements(power, with(
                    石英, 200,
                    phaseFabric, 50,
                    碳板, 30,
                    液电池, 20
            ));
            powerProduction = 700 / 60f;
            health = 220;
            size = 4;
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(){{sinMag = 0.6f;sinScl = 10f;color = Color.valueOf("ff9b59ff");}});}};


       /* 低压太阳发电机 = new ConsumeGenerator("低压太阳发电机") {{
            //localizedName = "低压太阳发电机";
            consumeItems(with(碳板, 1
            ));
            consumeLiquid(Liquids.water, 3 / 60f);

            requirements(power, with(
                    copper, 120,
                    lead, 120,
                    graphite, 80,
                    空壳, 80,
                    碳板, 5
            ));

            health = 300;
            itemDuration = 470;
            powerProduction = 40f;
            size = 2;
            itemCapacity = 2;
            liquidCapacity = 10;
            // ambientSound = Sounds.hum;
            // ambientSoundVolume = 0.06f;


        }};
      addToTree(低压太阳发电机, 超大型太阳能板);

        中压太阳发电机 = new ConsumeGenerator("中压太阳发电机") {{
            //localizedName = "中压太阳发电机";
            consumeItems(with(碳板, 2
            ));
            consumeLiquid(Liquids.water, 6 / 60f);
            requirements(power, with(
                    copper, 200,
                    lead, 200,
                    graphite, 80,
                    空壳, 200,
                    碳板, 15,
                    石英, 200,
                    silicon, 120,
                    titanium, 80
            ));
            health = 320;
            itemDuration = 9 * 60;
            powerProduction = 80;
            size = 2;
            itemCapacity = 4;
            liquidCapacity = 10;
            // ambientSound = Sounds.hum;
            //ambientSoundVolume = 0.06f;
        }};
      addToTree(中压太阳发电机, 低压太阳发电机);

        高压太阳发电机 = new ConsumeGenerator("高压太阳发电机") {{
            //localizedName = "高压太阳发电机";
            consumeItems(with(碳板, 3
            ));
            consumeLiquid(Liquids.cryofluid, 6 / 60f);
            requirements(power, with(
                    copper, 400,
                    lead, 400,
                    graphite, 150,
                    空壳, 500,
                    铁, 80,
                    碳板, 40,
                    石英, 400,
                    silicon, 220,
                    titanium, 150
            ));
            health = 350;
            itemDuration = 12 * 60;
            powerProduction = 140;
            size = 3;
            itemCapacity = 6;
            liquidCapacity = 10;
            // ambientSound = Sounds.hum;
            //ambientSoundVolume = 0.06f;
        }};
      addToTree(高压太阳发电机, 中压太阳发电机);*/
        超级rtg发电机 = new ConsumeGenerator("超级rtg发电机") {{
            //localizedName = "超级rtg发电机";
            requirements(power, with(
                    相织硅, 60,
                    lead, 70,
                    graphite, 220,
                    silicon, 100,
                    铁, 75,
                    钻石, 30,
                    钴, 120
            ));
            size = 3;
            powerProduction = 800 / 60f;
            itemDuration = 60 * 8f;
            envEnabled = Env.any;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
            consume(new ConsumeItemRadioactive());
        }};

        地水发电机 = new ThermalGenerator("地水发电机") {{
            //localizedName = "地水发电机";
            requirements(power, with(
                    石英, 20,
                    lead, 20,
                    graphite, 20,
                    silicon, 10,
                    铁, 5
            ));
            health = 250;
            attribute = Attribute.water;
            powerProduction = 320f / 60;
            generateEffect = Fx.reactorsmoke;
            effectChance = 0.011f;
            size = 2;
            floating = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
        }};


        地水触及机 = new ThermalGenerator("地水触及机") {{
            //localizedName = "地水触及机";
            requirements(power, with(
                    石英, 20,
                    lead, 20,
                    graphite, 20,
                    silicon, 10,
                    铁, 5,
                    空壳, 350,
                    钴, 50
            ));
            health = 320;
            attribute = Attribute.water;
            powerProduction = 430 / 60f;
            generateEffect = Fx.reactorsmoke;
            effectChance = 0.011f;
            size = 3;
            floating = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
        }};

        地引发电机 = new ThermalGenerator("地引发电机") {{
            //localizedName = "地引发电机";
            requirements(power, with(
                    镍板, 10,
                    lead, 150,
                    graphite, 125,
                    silicon, 80,
                    铁, 70,
                    空壳, 80,
                    碳板, 20
            ));
            health = 350;
            attribute = Attribute.heat;
            powerProduction = 510 / 60f;
            generateEffect = Fx.reactorsmoke;
            effectChance = 0.011f;
            size = 3;
            floating = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
        }};


        核反应堆 = new NuclearReactor("核反应堆") {{
            //localizedName = "核反应堆";
            requirements(power, with(
                    镍板, 25,
                    石英, 280,
                    金, 160,
                    钻石, 200,
                    固体放射物, 150
            ));
/*            explosionRadius = 10 * 8;
            explosionDamage = 4500;*/
            itemCapacity = 30;
            liquidCapacity = 100;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.24f;
            size = 3;
            health = 1400;
            itemDuration = 60f;
            powerProduction = 12000f / 60;
            heating = 0.002f;
            fuelItem = 放射混合物;
            consumeItem(放射混合物, 1);
            consumeLiquid(Liquids.cryofluid, 15 / 60f).update(false);
        }};



        石油冲击发电机 = new ImpactReactor("石油冲击发电机") {{
            //localizedName = "石油冲击发电机";
            requirements(power, with(
                    镍板, 400,
                    相织硅, 550,
                    titanium, 900,
                    啸动合金, 80
            ));
            health = 1200; //
            size = 3;
            buildCostMultiplier = 3;
            // itemCapacity = 10;
            liquidCapacity = 300;
            // itemDuration = 240;
            warmupSpeed = 0.0008f;
            powerProduction = 77000 / 60f;//4.2W发电量
            explosionRadius = 50 * 8; //爆炸半径 除以8
            explosionDamage = 14000; //爆炸伤害
            hasItems = false;
            //consumePowerBuffered(130000);
            consumePower(35000 / 60f);
            ambientSound = Sounds.pulse;
            ambientSoundVolume = 0.07f;
            consumeLiquid(oil, 1);

        }};



        相对发电机 = new ConsumeGenerator("相对发电机") {{
            canOverdrive = false;
            //localizedName = "相对发电机";
            requirements(power, with(
                    镍板, 750,
                    相织硅, 1300,
                    铁板, 2100,
                    啸动合金, 150,
                    黎辉水晶, 20
            ));
            powerProduction = 300000 / 60f;
            hasLiquids = true;
            hasItems = true;
            size = 5;
            ambientSound = Sounds.steam;
            generateEffect = Fx.generatespark;
            ambientSoundVolume = 0.03f;
            itemDuration = 60 * 60;//60秒
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(啸冷剂),
                    new DrawRegion("-turbine") {{//转转
                        rotateSpeed = 2f;
                    }},
                    new DrawDefault(),
                    new DrawWarmupRegion());

            consumeItem(黎辉水晶, 1);
            consumeLiquid(啸冷剂, 0.1f);
        }};



    }


}