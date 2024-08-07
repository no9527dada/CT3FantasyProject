package FantasyProject.content;

import arc.Core;
import arc.struct.Seq;
import CtCoreSystem.CoreSystem.type.factory.CreatorsUnitFactory;
import mindustry.Vars;
import mindustry.ai.types.MinerAI;
import mindustry.content.Liquids;
import mindustry.game.Team;
import mindustry.type.Category;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.CoreBlock;

import static FantasyProject.content.FantasyProjectItems.*;
import static FantasyProject.content.FantasyProjectUnitsSuu.*;
import static mindustry.content.UnitTypes.*;
import static mindustry.type.ItemStack.with;

//方块
public class FantasyProjectUnits {
    public static UnitType 魂灵2,魂灵;
    public static Block
            独影矿机工厂,幻型建造机工厂,巨像修复机工厂, T1单位工厂,T2单位工厂 ,T3单位工厂,T4单位工厂,魂灵运输机工厂,
            雷霆战机模拟器,fff;

    public static void load() {
        魂灵= new UnitType("魂灵"){{
            controller = u -> new MinerAI();
            canAttack = false;//关闭单位的武器,功能性单位
            playerControllable = false;//玩家无法操控
            physics =false;
            constructor =mono.constructor;
            itemCapacity=100;
            flying = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 5f;
            health = 10;
            engineSize = 1.8f;
            engineOffset = 5.7f;
            range = 50f;
            isEnemy = false;
        }};
        魂灵2= new UnitType("魂灵2"){{
            controller = u -> new MinerAI();
            canAttack = false;//关闭单位的武器,功能性单位
            playerControllable = false;//玩家无法操控
            physics =false;
            constructor =mono.constructor;
            itemCapacity=10;
            flying = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 5f;
            health = 10;
            engineSize = 1.8f;
            engineOffset = 5.7f;
            range = 50f;
            isEnemy = false;
        }};
        独影矿机工厂=new CreatorsUnitFactory("独影矿机工厂") {{
            solid = false;
            unitLimit = 3;
            requirements(Category.units, with(
                    铜, 130, 硅, 50
            ));
            plans = Seq.with(
                    new UnitPlan(mono, 60f * 50, with(石英,15))
            );
            size = 3;
            consumePower(120 / 60f);
            floating = true;
        }};
        魂灵运输机工厂=new CreatorsUnitFactory("魂灵运输机工厂") {{
            solid = false;
            unitLimit = 3;
            requirements(Category.units, with(
                    石英, 30, 石墨, 10
            ));
            plans = Seq.with(
                    new UnitPlan(魂灵, 60f * 5, with()),
            new UnitPlan(魂灵2, 60f * 5, with())
            );
            size = 3;
            consumePower(90 / 60f);
            floating = true;
        }};
        幻型建造机工厂=new CreatorsUnitFactory("幻型建造机工厂") {{
            solid = false;
            unitLimit = 2;
            requirements(Category.units, with(
                    铜, 150,石英,25, 石墨, 40,玻璃,30
            ));
            plans = Seq.with(
                    new UnitPlan(poly, 60f * 90, with(石墨, 30, 硅, 30))
            );
            size = 3;
            consumePower(160 / 60f);
            floating = true;
        }};
        巨像修复机工厂=new CreatorsUnitFactory("巨像修复机工厂") {{
            solid = false;
            unitLimit = 1;
            requirements(Category.units, with(
                    铜, 180,铅, 180,石英,70, 硅, 130,钛, 90, 钍, 50
            ));
            plans = Seq.with(
                    new UnitPlan(mega, 60f * 90, with(钛, 40, 硅, 50))
            );
            size = 3;
            consumePower(160 / 60f);
            floating = true;
        }};
        T1单位工厂=new CreatorsUnitFactory("T1单位工厂") {{
            solid = false;
            unitLimit = 4;
            requirements(Category.units, with(
                    铜, 50,铅, 40, 硅, 20
            ));
            plans = Seq.with(
                    new UnitPlan(flare, 60f * 40, with( 硅, 7)),
                    new UnitPlan(dagger, 60f * 25, with(硅, 6)),
                    new UnitPlan(crawler, 60f * 20, with( 硅, 5)),
                    new UnitPlan(nova, 60f * 35, with(硅, 6))


            );
            size = 3;
            consumePower(70 / 60f);
            floating = true;
        }};
        T2单位工厂=new CreatorsUnitFactory("T2单位工厂") {{
            solid = false;
            unitLimit = 4;
            requirements(Category.units, with(
                    铜, 50,铅, 40,石英,45, 铁, 20,钛,60
            ));
            plans = Seq.with(
                    new UnitPlan(zenith, 60f * 100, with( 石墨,20,硅, 30)),//苍穹
                    new UnitPlan(fortress, 60f * 90, with(钛,30,硅, 30)),//堡垒
                    new UnitPlan(spiroct, 60f * 110, with( 钍,30,硅, 25)),//蜘蛛
                    new UnitPlan(quasar, 60f * 80, with(玻璃,50,硅, 25))//耀星
            );
            size = 3;
            consumePower(230 / 60f);
            floating = true;
        }};
        T3单位工厂=new CreatorsUnitFactory("T3单位工厂") {{
            solid = false;
            unitLimit = 3;
            requirements(Category.units, with(
                   金 , 50,钴, 30, 铁板, 20,钍,90
            ));
            plans = Seq.with(
                    new UnitPlan(antumbra, 60f * 60*2, with( 铁,30,镍, 35)),//月影
                    new UnitPlan(scepter, 60f * 60*1.8f, with(铁,25,钴,50)),//权杖
                    new UnitPlan(arkyid, 60f * 60*2.2f, with( 铁,20,塑钢,35)),//蜘蛛
                    new UnitPlan(vela, 60f * 60*2.5f, with(铁,40,布,30))//灾星
            );
            size = 3;
            consumePower(900 / 60f);
            floating = true;
        }};
        T4单位工厂=new CreatorsUnitFactory("T4单位工厂") {{
            solid = false;
            unitLimit = 3;
            requirements(Category.units, with(
                    镍板, 180,铁, 260, 钴, 160,石英,270,钛,220,钍,300
            ));
            plans = Seq.with(
                    new UnitPlan(eclipse, 60f * 90*7f, with( 合金,120,相织硅,140,金, 150)),//日蚀
                    new UnitPlan(reign, 60f * 90*7.5f, with( 合金,120,钛合金,160,铁板, 200)),//王座
                    new UnitPlan(toxopid, 60f * 90*7f, with( 合金,120,相织硅,220,钛合金, 170)),//天蝎
                    new UnitPlan(corvus, 60f * 90*8f, with(合金,120,镍板,200, 液电池, 7)),//死星
                    new UnitPlan(oct, 60f * 90*7.3f, with(合金,120,钻石,150,镍, 7))//oct

            );
            size = 5;
            consumePower(2200 / 60f);
            consumeLiquid(Liquids.cryofluid, 0.4f);
            floating = true;
        }};
        雷霆战机模拟器=new CreatorsUnitFactory("雷霆战机模拟器") {{
            solid = false;
            unitLimit = 2;
            requirements(Category.units, with(
                    铁, 30, 布, 40,铜,100,铅,100
            ));
            plans = Seq.with(
                    new UnitPlan(天穹, 60f * 5, with(金,100)),
                    new UnitPlan(飞鹰, 60f * 5, with(铁板,50)),
                    new UnitPlan(秃鹫, 60f * 5, with(镍板,50)),
                    new UnitPlan(战鹰, 60f * 5, with(钻石,80)),
                    new UnitPlan(天泽, 60f * 5, with(钛合金,100))
            );
            size = 5;
            consumePower(1000 / 60f);
            floating = true;
            buildCostMultiplier = 0;
        }
            //  数字代表允许建筑的数量，最多是数字的值+1
            public int 数量 = 1;

            //瞬间替换和扣除物品
            @Override
            public void placeBegan(Tile tile, Block previous) {
                if (!Vars.state.rules.infiniteResources) {
                    CoreBlock.CoreBuild core = Vars.player.team().core();
                    core.items.remove(requirements);
                }
                tile.setBlock(this, tile.team());
                tile.block().placeEffect.at(tile, tile.block().size);
            }

            //允许放置
            @Override
            public boolean canPlaceOn(Tile tile, Team team, int rotation) {
                CoreBlock.CoreBuild core = team.core();
                //size后面数字代表允许建筑的数量，最多是数字的值+1
                if (core == null || Vars.state.teams.get(team).getBuildings(this).size > 数量 - 1
                        || (!Vars.state.rules.infiniteResources && !core.items.has(requirements, Vars.state.rules.buildCostMultiplier)
                )) return false;
                return super.canPlaceOn(tile, team, rotation);
            }

            //显示红字
            @Override
            public void drawPlace(int x, int y, int rotation, boolean valid) {
                CoreBlock.CoreBuild core = Vars.player.team().core();
                if (!Vars.state.rules.infiniteResources && !core.items.has(requirements, Vars.state.rules.buildCostMultiplier)) {
                    drawPlaceText(Core.bundle.format("bar.noresources"), x, y, valid);
                } else if (Vars.state.teams.get(Vars.player.team()).getBuildings(this).size > 数量 - 1)
                    drawPlaceText(Core.bundle.get("QuantityLimit.限制最大数量") + 数量, x, y, valid);
                super.drawPlace(x, y, rotation, valid);
            }
        };
    }
}