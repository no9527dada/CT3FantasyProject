package FantasyProject.content;

import arc.Core;
import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.game.Objectives;
import mindustry.game.Objectives.OnSector;
import mindustry.game.Objectives.Research;
import mindustry.game.Objectives.SectorComplete;
import mindustry.type.ItemStack;

import static FantasyProject.content.FantasyProjectDefense.*;
import static FantasyProject.content.FantasyProjectDrill.*;
import static FantasyProject.content.FantasyProjectGenericCrafter.*;
import static FantasyProject.content.FantasyProjectItems.*;
import static FantasyProject.content.FantasyProjectMaps.*;
import static FantasyProject.content.FantasyProjectPlanet.FantasyPlanet;
import static FantasyProject.content.FantasyProjectPower.*;
import static FantasyProject.content.FantasyProjectTurrets.*;
import static FantasyProject.content.FantasyProjectUnits.*;
import static FantasyProject.content.FantasyProjectUnitsSuu.*;
import static FantasyProject.content.FantasyProjectWuLiu.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.Items.plastanium;
import static mindustry.content.SectorPresets.crateredBattleground;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class FantasyProjectTechTree {
    public static float TechTrees5倍率 = 1;

    public static void load() {
        FantasyPlanet.techTree = nodeRoot(Core.bundle.format("FantasyPlanetTT"), FantasyPlanet, true, () -> {

            node(coreShard, () -> {
                //工厂
                node(石英提取机, () -> {
                    node(铁锻造机, Seq.with(new Objectives.Research(mechanicalDrill)), () -> {
                        node(石英磨练机, () -> {
                            node(多重冶炼厂, Seq.with(new Objectives.Research(siliconSmelter)), () -> {
                            });
                            node(多重窑炉, Seq.with(new Objectives.Research(cultivator)), () -> {
                            });
                            node(大型培养机, Seq.with(new Objectives.Research(cultivator)), () -> {
                            });
                            node(碳板压缩机, Seq.with(new Objectives.Research(multiPress)), () -> {
                            });
                            node(煤炭离心机, Seq.with(new Objectives.Research(coalCentrifuge)), () -> {
                            });
                            node(孢子沉压机, Seq.with(new Objectives.Research(sporePress)), () -> {
                            });
                            node(多重编织机, Seq.with(new Objectives.Research(phaseWeaver)), () -> {
                            });
                            node(多重塑钢机, Seq.with(new Objectives.Research(plastaniumCompressor)), () -> {
                            });
                            node(合金锤炼厂, Seq.with(new Objectives.Research(surgeSmelter)), () -> {
                            });

                        });
                        node(空壳制造机, Seq.with(new Objectives.Research(multiPress)), () -> {
                            node(军火库, () -> {
                            });

                            node(弹药厂_爆破, () -> {
                            });
                            node(弹药厂_冷冻, () -> {
                            });
                            node(弹药厂_碎裂, () -> {
                            });
                            node(弹药厂_硬直, () -> {
                            });
                            node(液电池制造厂, () -> {
                            });
                            node(物品厂_水瓶, () -> {
                            });
                        });

                        node(钻石离心机, () -> {
                            node(钻石混合物反应机, () -> {

                                node(钻石提炼机, () -> {
                                });
                            });
                            node(钻石矿加工厂, () -> {
                            });
                        });


                        node(辐射混合机, () -> {
                            node(矿物离心机, () -> {
                                node(粒子离心机, () -> {
                                });
                                node(资源产生器, () -> {
                                });
                            });
                        });

                        node(冷冻液发生机, () -> {
                            node(制冷液混合机, () -> {
                                node(啸动冲击械, () -> {
                                });
                            });
                        });
                        node(硫粉发生机, Seq.with(new Objectives.Research(multiPress)), () -> {
                            node(爆炸冲击机, () -> {
                            });
                            node(固体放射机);
                            node(放射混合器);
                        });
                        node(链式锻造机, () -> {
                            node(镍板合成机, () -> {
                                node(啸动冶炼机, () -> {
                                    node(军火材料机, () -> {
                                        node(水晶复合器, () -> {
                                        });
                                    });
                                });
                                node(镍板混合器, () -> {
                                });

                            });
                        });
                        node(铁板锻造机, () -> {
                            node(钛合金反应炉, Seq.with(new Objectives.SectorComplete(盐碱荒滩)), () -> {
                                node(相织反应炉, () -> {
                                });
                            });
                            node(铁板重型加工厂, () -> {
                            });
                            node(大型粉碎机, Seq.with(new Objectives.Research(blastMixer)), () -> {
                            });
                        });
                        node(黄金熔炼器, () -> {
                            node(混合熔炼器, () -> {
                            });
                        });


                        node(资源转换器_废料, () -> {
                            node(资源转换器_铜铅, () -> {
                            });
                            node(资源转换器_钛, () -> {
                            });
                            node(资源转换器_钍, () -> {
                            });
                            node(资源转换器_钴, Seq.with(new Objectives.Research(钴)), () -> {
                                node(资源转换器_镍, Seq.with(new Objectives.SectorComplete(冲击区)), () -> {
                                });
                                node(资源转换器_塑钢, Seq.with(new Objectives.Research(plastanium)), () -> {
                                });
                            });
                        });

                    });
                });

                node(大型维修点, Seq.with(new Objectives.Research(repairPoint)), () -> {
                    node(跳波器, () -> {
                        node(破墙器, () -> {
                        });
                    });
                    node(增幅修复仪, () -> {
                        node(聚能修复仪, () -> {
                        });
                    });
                    node(极速投影器, () -> {
                        node(增幅投影器, () -> {
                            node(聚能投影械, () -> {
                            });
                        });
                    });
                    node(增幅护盾仪, () -> {
                    });
                });
                // 防御设施
                node(铅墙, Seq.with(new Objectives.Research(copperWall)), () -> {
                    node(大型铅墙, () -> {
                        node(硅墙, () -> {
                            node(大型硅墙, () -> {
                            });
                            node(钴墙, () -> {
                                node(大型钴墙, () -> {
                                });
                                node(钴门, () -> {
                                });
                                node(高级塑钢墙, () -> {
                                    node(大型高级塑钢墙, () -> {
                                    });
                                });
                                node(钛合金墙, () -> {
                                    node(大型钛合金墙, () -> {
                                        node(巨型钛合金墙, () -> {
                                            node(超大型钛合金墙, () -> {
                                            });
                                        });
                                    });
                                });
                            });
                            node(相织硅墙, Seq.with(new Objectives.Research(phaseWallLarge)), () -> {
                                node(大型相织硅墙, () -> {
                                });
                            });
                        });
                    });
                });


                //物流
                node(大型仓库, Seq.with(new Objectives.Research(vault)), () -> {
                    node(连锁仓库, () -> {
                    });
                    node(超大型仓库, () -> {
                        node(战地仓库, () -> {

                        });
                    });
                    node(动能卸货器, () -> {
                    });
                    node(驱动器, Seq.with(new Objectives.Research(massDriver)), () -> {
                        node(数据驱动器, () -> {
                            node(质量转换终端, () -> {
                                node(质量驱逐器, () -> {
                                });
                            });
                        });
                    });
                    node(大型储液罐, Seq.with(new Objectives.Research(liquidTank)), () -> {
                        node(钴制导管, () -> {
                            node(硬速导管, () -> {
                            });
                        });
                    });
                });

                node(镍板连接器, Seq.with(new Objectives.Research(junction)), () -> {
                    node(钴传送带, Seq.with(new Objectives.Research(armoredConveyor)), () -> {
                        node(装甲钴传送带, () -> {
                        });
                        node(镍板传送带, () -> {
                            node(装甲镍板传送带, () -> {
                            });
                            node(镍板传送带, () -> {
                            });
                            node(啸动传送带, () -> {
                            });
                            node(装甲啸动传送带, () -> {
                                node(钻石传送带, () -> {
                                });
                            });
                        });
                    });
                    node(钍传送带桥, Seq.with(new Objectives.Research(conveyor)), () -> {
                        node(钴传送带桥, () -> {
                            node(钻石送带桥, () -> {
                            });
                        });
                    });
                    node(钍导管桥, Seq.with(new Objectives.Research(phaseConduit)), () -> {
                        node(钴导管桥, () -> {
                        });
                    });
                });

                //单位
                node(魂灵, () -> {
                    node(魂灵运输机工厂, () -> {
                        node(魂灵2, () -> {
                        });
                    });

                    node(独影矿机工厂, () -> {
                        node(幻型建造机工厂, () -> {
                            node(巨像修复机工厂, () -> {
                            });
                        });
                    });
                    node(T1单位工厂, () -> {
                        node(T2单位工厂, () -> {
                            node(T3单位工厂, () -> {
                                node(T4单位工厂, () -> {
                                });
                            });
                        });
                    });
                    node(雷霆战机模拟器, () -> {
                        node(天穹, ItemStack.with(金, 20000), () -> {
                            node(飞鹰, ItemStack.with(铁板, 20000), () -> {
                                node(秃鹫, ItemStack.with(镍板, 20000), () -> {
                                    node(战鹰, ItemStack.with(钻石, 20000), () -> {
                                        node(天泽, ItemStack.with(钛合金, 20000), () -> {
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
                //炮塔
                node(真双管炮, Seq.with(new Objectives.Research(duo)), () -> {
                    node(散射炮, Seq.with(new Objectives.Research(scatter)), () -> {
                    });
                    node(咻咻炮, () -> {
                        node(制裁, () -> {
                        });
                    });
                    node(灭亡, () -> {
                        node(魂灭, () -> {
                        });
                    });
                    node(魄散, Seq.with(new Objectives.SectorComplete(废墟海岸)), () -> {
                        node(毁灭, () -> {
                        });
                    });
                    node(追动, Seq.with(new Objectives.Research(cyclone)), () -> {
                        node(皇后, () -> {
                        });
                        node(帝王, () -> {
                        });
                    });
                    node(光棱塔, Seq.with(new Objectives.Research(foreshadow)), () -> {
                        node(超级光棱塔, () -> {
                        });
                    });
                    node(空之驱逐, () -> {
                        node(空中祸害, () -> {
                        });
                    });
                    node(起源, () -> {
                        node(排山, () -> {
                        });
                        node(终焉, () -> {
                            node(尘埃, () -> {
                            });
                        });

                    });
                });
                //电力
                node(火能发电机, Seq.with(new Objectives.Research(thermalGenerator)), () -> {
                    node(汽轮发电机, () -> {
                        node(超大型电池, Seq.with(new Objectives.Research(batteryLarge)), () -> {
                            node(充能水晶, () -> {
                            });
                        });
                        node(连接终端, Seq.with(new Objectives.Research(surgeTower)), () -> {

                            node(充能节点, () -> {
                            });
                        });
                        node(超大型太阳能板, Seq.with(new Objectives.Research(largeSolarPanel)), () -> {
                        });
                        node(地水发电机, () -> {
                            node(地水触及机, Seq.with(new Objectives.SectorComplete(盐碱荒滩)), () -> {
                            });
                            node(地引发电机, () -> {
                            });
                        });
                        node(超级rtg发电机, Seq.with(new Objectives.Research(thermalGenerator)), () -> {

                            node(离心发电机, () -> {
                            });

                            node(核反应堆, () -> {
                                node(石油冲击发电机, () -> {
                                    node(相对发电机, () -> {
                                    });
                                });
                            });
                        });
                    });
                });
                node(中型机械钻头, () -> {
                    node(大型机械钻头, () -> {
                        node(金刚钻头, () -> {
                            node(合金钻头, () -> {
                            });
                        });
                    });
                    node(中型抽水机, () -> {
                        node(大型抽水机, () -> {
                            node(大型抽水机, () -> {
                                node(液体离心机, () -> {
                                });
                            });
                        });
                        node(大型机械泵, () -> {
                            node(超大型机械泵, () -> {
                                node(动能泵, () -> {
                                });
                            });
                        });
                    });
                });
                node(零号, Seq.with(new Objectives.Research(surgeSmelter)), () -> {
                    node(冰冻森林, Seq.with(new Objectives.SectorComplete(零号)), () -> {
                        node(陨石坑, Seq.with(new Objectives.SectorComplete(冰冻森林)), () -> {
                            node(生物质合成区, Seq.with(new Objectives.SectorComplete(陨石坑)), () -> {
                                node(真菌通道, Seq.with(new Objectives.SectorComplete(生物质合成区)), () -> {
                                    node(提取前哨, Seq.with(new Objectives.SectorComplete(真菌通道)), () -> {
                                        node(增生区, Seq.with(new Objectives.SectorComplete(提取前哨)), () -> {
                                        });
                                    });
                                });
                            });
                            node(绵延群山, Seq.with(new Objectives.SectorComplete(生物质合成区)), () -> {
                                node(冲击区, Seq.with(new Objectives.SectorComplete(绵延群山)), () -> {
                                    node(油田, Seq.with(new Objectives.SectorComplete(冲击区)), () -> {
                                        node(核矩阵, Seq.with(new Objectives.SectorComplete(油田)), () -> {
                                            node(荒芜裂谷, Seq.with(new Objectives.SectorComplete(核矩阵)), () -> {
                                            });
                                        });
                                    });
                                });
                            });
                            node(盐碱荒滩, Seq.with(new Objectives.SectorComplete(绵延群山)), () -> {
                                node(废墟海岸, Seq.with(new Objectives.SectorComplete(盐碱荒滩)), () -> {
                                    node(风吹海岛, Seq.with(new Objectives.SectorComplete(废墟海岸)), () -> {
                                        node(海岸线, Seq.with(new Objectives.SectorComplete(风吹海岛)), () -> {
                                            node(海军要塞, Seq.with(new Objectives.SectorComplete(海岸线)), () -> {
                                                node(行星发射终端, Seq.with(new Objectives.SectorComplete(海军要塞)), () -> {
                                                    node(赤色总部, Seq.with(new Objectives.SectorComplete(行星发射终端)), () -> {
                                                    });
                                                    node(熔岩要塞, Seq.with(new Objectives.SectorComplete(行星发射终端)), () -> {
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });


            node(coreShard, () -> {

                node(conveyor, () -> {

                    node(junction, () -> {
                        node(router, () -> {
                            node(advancedLaunchPad, Seq.with(new SectorComplete(extractionOutpost)), () -> {
                                node(landingPad, () -> {
                                    node(interplanetaryAccelerator, Seq.with(new SectorComplete(planetaryTerminal)), () -> {

                                    });
                                });
                            });

                            node(distributor);
                            node(sorter, () -> {
                                node(invertedSorter);
                                node(overflowGate, () -> {
                                    node(underflowGate);
                                });
                            });
                            node(container, Seq.with(new SectorComplete(biomassFacility)), () -> {
                                node(unloader);
                                node(vault, Seq.with(new SectorComplete(stainedMountains)), () -> {

                                });
                            });

                            node(itemBridge, () -> {
                                node(titaniumConveyor, Seq.with(new SectorComplete(crateredBattleground)), () -> {
                                    node(phaseConveyor, () -> {
                                        node(massDriver, () -> {

                                        });
                                    });

                                    node(payloadConveyor, () -> {
                                        node(payloadRouter, () -> {

                                        });
                                    });

                                    node(armoredConveyor, () -> {
                                        node(plastaniumConveyor, () -> {

                                        });
                                    });
                                });
                            });
                        });
                    });
                });

                node(coreFoundation, () -> {
                    node(coreNucleus, () -> {

                    });
                });

                node(mechanicalDrill, () -> {

                    node(mechanicalPump, () -> {
                        node(conduit, () -> {
                            node(liquidJunction, () -> {
                                node(liquidRouter, () -> {
                                    node(liquidContainer, () -> {
                                        node(liquidTank);
                                    });

                                    node(bridgeConduit);

                                    node(pulseConduit, Seq.with(new SectorComplete(windsweptIslands)), () -> {
                                        node(phaseConduit, () -> {

                                        });

                                        node(platedConduit, () -> {

                                        });

                                        node(rotaryPump, () -> {
                                            node(impulsePump, () -> {

                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });

                    node(graphitePress, () -> {
                        node(pneumaticDrill, Seq.with(new SectorComplete(frozenForest)), () -> {
                            node(cultivator, Seq.with(new SectorComplete(biomassFacility)), () -> {

                            });

                            node(laserDrill, () -> {
                                node(blastDrill, Seq.with(new SectorComplete(nuclearComplex)), () -> {

                                });

                                node(waterExtractor, Seq.with(new SectorComplete(saltFlats)), () -> {
                                    node(oilExtractor, () -> {

                                    });
                                });
                            });
                        });

                        node(pyratiteMixer, () -> {
                            node(blastMixer, Seq.with(new SectorComplete(facility32m)), () -> {

                            });
                        });

                        node(siliconSmelter, () -> {

                            node(sporePress, () -> {
                                node(coalCentrifuge, () -> {
                                    node(multiPress, () -> {
                                        node(siliconCrucible, () -> {

                                        });
                                    });
                                });

                                node(plastaniumCompressor, Seq.with(new SectorComplete(windsweptIslands), new OnSector(tarFields)), () -> {
                                    node(phaseWeaver, Seq.with(new SectorComplete(tarFields)), () -> {

                                    });
                                });
                            });

                            node(kiln, Seq.with(new OnSector(crateredBattleground)), () -> {
                                node(pulverizer, () -> {
                                    node(incinerator, () -> {
                                        node(melter, () -> {
                                            node(surgeSmelter, () -> {

                                            });

                                            node(separator, () -> {
                                                node(disassembler, () -> {

                                                });
                                            });

                                            node(cryofluidMixer, () -> {

                                            });
                                        });
                                    });
                                });
                            });

                            //logic disabled until further notice
                            node(microProcessor, () -> {
                                node(switchBlock, () -> {
                                    node(message, () -> {
                                        node(logicDisplay, () -> {
                                            node(largeLogicDisplay, () -> {

                                            });
                                        });

                                        node(memoryCell, () -> {
                                            node(memoryBank, () -> {

                                            });
                                        });
                                    });

                                    node(logicProcessor, () -> {
                                        node(hyperProcessor, () -> {

                                        });
                                    });
                                });
                            });

                            node(illuminator, () -> {

                            });
                        });
                    });


                    node(combustionGenerator, Seq.with(new Research(Items.coal)), () -> {
                        node(powerNode, () -> {
                            node(powerNodeLarge, () -> {
                                node(diode, () -> {
                                    node(surgeTower, () -> {

                                    });
                                });
                            });

                            node(battery, () -> {
                                node(batteryLarge, () -> {

                                });
                            });

                            node(mender, () -> {
                                node(mendProjector, () -> {
                                    node(forceProjector, Seq.with(new SectorComplete(impact0078)), () -> {
                                        node(overdriveProjector, Seq.with(new SectorComplete(impact0078)), () -> {
                                            node(overdriveDome, Seq.with(new SectorComplete(impact0078)), () -> {

                                            });
                                        });
                                    });

                                    node(repairPoint, () -> {
                                        node(repairTurret, () -> {

                                        });
                                    });
                                });
                            });

                            node(steamGenerator, Seq.with(new SectorComplete(crateredBattleground)), () -> {
                                node(thermalGenerator, () -> {
                                    node(differentialGenerator, () -> {
                                        node(thoriumReactor, Seq.with(new Research(Liquids.cryofluid)), () -> {
                                            node(impactReactor, () -> {

                                            });

                                            node(rtgGenerator, () -> {

                                            });
                                        });
                                    });
                                });
                            });

                            node(solarPanel, () -> {
                                node(largeSolarPanel, () -> {

                                });
                            });
                        });
                    });
                });

                node(duo, () -> {
                    node(copperWall, () -> {
                        node(copperWallLarge, () -> {
                            node(scrapWall, () -> {
                                node(scrapWallLarge, () -> {
                                    node(scrapWallHuge, () -> {
                                        node(scrapWallGigantic);
                                    });
                                });
                            });

                            node(titaniumWall, () -> {
                                node(titaniumWallLarge);

                                node(door, () -> {
                                    node(doorLarge);
                                });

                                node(plastaniumWall, () -> {
                                    node(plastaniumWallLarge, () -> {

                                    });
                                });
                                node(thoriumWall, () -> {
                                    node(thoriumWallLarge);
                                    node(surgeWall, () -> {
                                        node(surgeWallLarge);
                                        node(phaseWall, () -> {
                                            node(phaseWallLarge);
                                        });
                                    });
                                });
                            });
                        });
                    });

                    node(scatter, () -> {
                        node(hail, Seq.with(new SectorComplete(crateredBattleground)), () -> {
                            node(salvo, () -> {
                                node(swarmer, () -> {
                                    node(cyclone, () -> {
                                        node(spectre, Seq.with(new SectorComplete(nuclearComplex)), () -> {

                                        });
                                    });
                                });

                                node(ripple, () -> {
                                    node(fuse, () -> {

                                    });
                                });
                            });
                        });
                    });

                    node(scorch, () -> {
                        node(arc, () -> {
                            node(wave, () -> {
                                node(parallax, () -> {
                                    node(segment, () -> {

                                    });
                                });

                                node(tsunami, () -> {

                                });
                            });

                            node(lancer, () -> {
                                node(meltdown, () -> {
                                    node(foreshadow, () -> {

                                    });
                                });

                                node(shockMine, () -> {

                                });
                            });
                        });
                    });
                });

                node(groundFactory, () -> {

                    node(dagger, () -> {
                        node(mace, () -> {
                            node(fortress, () -> {
                                node(scepter, () -> {
                                    node(reign, () -> {

                                    });
                                });
                            });
                        });

                        node(nova, () -> {
                            node(pulsar, () -> {
                                node(quasar, () -> {
                                    node(vela, () -> {
                                        node(corvus, () -> {

                                        });
                                    });
                                });
                            });
                        });

                        //override research requirements to have graphite, not coal
                        node(crawler, ItemStack.with(Items.silicon, 400, Items.graphite, 400), () -> {
                            node(atrax, () -> {
                                node(spiroct, () -> {
                                    node(arkyid, () -> {
                                        node(toxopid, Seq.with(new SectorComplete(mycelialBastion)), () -> {

                                        });
                                    });
                                });
                            });
                        });
                    });

                    node(airFactory, () -> {
                        node(flare, () -> {
                            node(horizon, () -> {
                                node(zenith, () -> {
                                    node(antumbra, () -> {
                                        node(eclipse, () -> {

                                        });
                                    });
                                });
                            });

                            node(mono, () -> {
                                node(poly, () -> {
                                    node(mega, () -> {
                                        node(quad, () -> {
                                            node(oct, () -> {

                                            });
                                        });
                                    });
                                });
                            });
                        });

                        node(navalFactory, Seq.with(new OnSector(windsweptIslands)), () -> {
                            node(risso, () -> {
                                node(minke, () -> {
                                    node(bryde, () -> {
                                        node(sei, () -> {
                                            node(omura, () -> {

                                            });
                                        });
                                    });
                                });

                                node(retusa, Seq.with(new SectorComplete(windsweptIslands)), () -> {
                                    node(oxynoe, Seq.with(new SectorComplete(coastline)), () -> {
                                        node(cyerce, () -> {
                                            node(aegires, () -> {
                                                node(navanax, Seq.with(new SectorComplete(navalFortress)), () -> {

                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });

                    node(additiveReconstructor, Seq.with(new SectorComplete(crateredBattleground)), () -> {
                        node(multiplicativeReconstructor, Seq.with(new SectorComplete(frontier)), () -> {
                            node(exponentialReconstructor, () -> {
                                node(tetrativeReconstructor, () -> {

                                });
                            });
                        });
                    });
                });

                node(groundZero, () -> {
                    node(frozenForest, Seq.with(
                            new SectorComplete(groundZero),
                            new Research(junction),
                            new Research(router)
                    ), () -> {
                        node(crateredBattleground, Seq.with(
                                new SectorComplete(frozenForest),
                                new Research(mender),
                                new Research(combustionGenerator)
                        ), () -> {
                            node(fungalPass, Seq.with(
                                    new SectorComplete(crateredBattleground),
                                    new Research(groundFactory),
                                    new Research(dagger)
                            ), () -> {
                                node(frontier, Seq.with(
                                        new SectorComplete(biomassFacility),
                                        new SectorComplete(fungalPass),
                                        new Research(groundFactory),
                                        new Research(airFactory),
                                        new Research(additiveReconstructor),
                                        new Research(mace),
                                        new Research(mono)
                                ), () -> {
                                    node(overgrowth, Seq.with(
                                            new SectorComplete(frontier),
                                            new SectorComplete(windsweptIslands),
                                            new Research(multiplicativeReconstructor),
                                            new Research(fortress),
                                            new Research(ripple),
                                            new Research(salvo),
                                            new Research(cultivator),
                                            new Research(sporePress)
                                    ), () -> {
                                        node(mycelialBastion, Seq.with(
                                                new Research(atrax),
                                                new Research(spiroct),
                                                new Research(arkyid),
                                                new Research(multiplicativeReconstructor),
                                                new Research(exponentialReconstructor)
                                        ), () -> {

                                        });

                                        node(atolls, Seq.with(
                                                new SectorComplete(windsweptIslands),
                                                new Research(multiplicativeReconstructor),
                                                new Research(mega)
                                        ), () -> {

                                        });
                                    });
                                });

                                node(taintedWoods, Seq.with(
                                        new SectorComplete(biomassFacility),
                                        new SectorComplete(fungalPass),
                                        new Research(Items.sporePod),
                                        new Research(wave)
                                ), () -> {

                                });
                            });

                            node(ruinousShores, Seq.with(
                                    new SectorComplete(crateredBattleground),
                                    new Research(graphitePress),
                                    new Research(kiln),
                                    new Research(mechanicalPump)
                            ), () -> {
                                node(windsweptIslands, Seq.with(
                                        new SectorComplete(ruinousShores),
                                        new Research(pneumaticDrill),
                                        new Research(hail),
                                        new Research(siliconSmelter),
                                        new Research(steamGenerator)
                                ), () -> {
                                    node(tarFields, Seq.with(
                                            new SectorComplete(windsweptIslands),
                                            new Research(coalCentrifuge),
                                            new Research(conduit),
                                            new Research(wave)
                                    ), () -> {
                                        node(impact0078, Seq.with(
                                                new SectorComplete(tarFields),
                                                new Research(Items.thorium),
                                                new Research(lancer),
                                                new Research(salvo),
                                                new Research(coreFoundation)
                                        ), () -> {
                                            node(desolateRift, Seq.with(
                                                    new SectorComplete(impact0078),
                                                    new Research(thermalGenerator),
                                                    new Research(thoriumReactor),
                                                    new Research(coreNucleus)
                                            ), () -> {
                                                node(planetaryTerminal, Seq.with(
                                                        new SectorComplete(desolateRift),
                                                        new SectorComplete(nuclearComplex),
                                                        new SectorComplete(overgrowth),
                                                        new SectorComplete(extractionOutpost),
                                                        new SectorComplete(saltFlats),
                                                        new Research(risso),
                                                        new Research(minke),
                                                        new Research(bryde),
                                                        new Research(sei),
                                                        new Research(omura),
                                                        new Research(spectre),
                                                        new Research(advancedLaunchPad),
                                                        new Research(massDriver),
                                                        new Research(impactReactor),
                                                        new Research(additiveReconstructor),
                                                        new Research(exponentialReconstructor),
                                                        new Research(tetrativeReconstructor)
                                                ), () -> {});
                                            });
                                        });
                                    });

                                    node(facility32m, Seq.with(
                                            new Research(pneumaticDrill),
                                            new SectorComplete(stainedMountains)
                                    ), () -> {
                                        node(extractionOutpost, Seq.with(
                                                new SectorComplete(windsweptIslands),
                                                new SectorComplete(fungalPass),
                                                new SectorComplete(facility32m),
                                                new Research(groundFactory),
                                                new Research(nova),
                                                new Research(airFactory),
                                                new Research(mono)
                                        ), () -> {
                                            //TODO: removed for now
                                        /*node(polarAerodrome, Seq.with(
                                        new SectorComplete(fungalPass),
                                        new SectorComplete(desolateRift),
                                        new SectorComplete(overgrowth),
                                        new Research(multiplicativeReconstructor),
                                        new Research(zenith),
                                        new Research(swarmer),
                                        new Research(cyclone),
                                        new Research(blastDrill),
                                        new Research(blastDrill),
                                        new Research(massDriver)
                                        ), () -> {

                                        });
                                        */
                                        });
                                    });

                                    node(saltFlats, Seq.with(
                                            new SectorComplete(windsweptIslands),
                                            new SectorComplete(fungalPass),
                                            new SectorComplete(frontier),
                                            new Research(groundFactory),
                                            new Research(additiveReconstructor),
                                            new Research(airFactory),
                                            new Research(door)
                                    ), () -> {
                                        node(testingGrounds, Seq.with(
                                                new Research(cryofluidMixer),
                                                new Research(Liquids.cryofluid),
                                                new Research(waterExtractor),
                                                new Research(ripple)
                                        ), () -> {

                                        });

                                        node(coastline, Seq.with(
                                                new SectorComplete(windsweptIslands),
                                                new SectorComplete(saltFlats),
                                                new Research(navalFactory),
                                                new Research(payloadConveyor)
                                        ), () -> {

                                            node(navalFortress, Seq.with(
                                                    new SectorComplete(coastline),
                                                    new SectorComplete(extractionOutpost),
                                                    new Research(coreNucleus),
                                                    new Research(massDriver),
                                                    new Research(oxynoe),
                                                    new Research(minke),
                                                    new Research(bryde),
                                                    new Research(cyclone),
                                                    new Research(ripple)
                                            ), () -> {
                                                node(weatheredChannels, Seq.with(
                                                        new SectorComplete(impact0078),
                                                        new Research(bryde),
                                                        new Research(surgeSmelter),
                                                        new Research(overdriveProjector)
                                                ), () -> {

                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });

                        node(biomassFacility, Seq.with(
                                new SectorComplete(frozenForest),
                                new Research(powerNode),
                                new Research(steamGenerator),
                                new Research(scatter),
                                new Research(graphitePress)
                        ), () -> {

                            node(stainedMountains, Seq.with(
                                    new SectorComplete(biomassFacility),
                                    new Research(pneumaticDrill),
                                    new Research(siliconSmelter)
                            ), () -> {

                                //TODO bad order
                                node(infestedCanyons, Seq.with(
                                        new SectorComplete(fungalPass),
                                        new SectorComplete(frontier),
                                        new Research(navalFactory),
                                        new Research(risso),
                                        new Research(minke),
                                        new Research(additiveReconstructor)
                                ), () -> {
                                    //TODO difficulty jump!
                                    node(nuclearComplex, Seq.with(
                                            new SectorComplete(fungalPass),
                                            new Research(thermalGenerator),
                                            new Research(laserDrill),
                                            new Research(Items.plastanium),
                                            new Research(swarmer)
                                    ), () -> {

                                    });
                                });


                            });
                        });
                    });
                });

                nodeProduce(Items.copper, () -> {
                    nodeProduce(Liquids.water, () -> {

                    });

                    nodeProduce(Items.lead, () -> {
                        nodeProduce(Items.titanium, () -> {
                            nodeProduce(Liquids.cryofluid, () -> {

                            });

                            nodeProduce(Items.thorium, () -> {
                                nodeProduce(Items.surgeAlloy, () -> {

                                });

                                nodeProduce(Items.phaseFabric, () -> {

                                });
                            });
                        });

                        nodeProduce(Items.metaglass, () -> {

                        });
                    });

                    nodeProduce(Items.sand, () -> {
                        nodeProduce(Items.scrap, () -> {
                            nodeProduce(Liquids.slag, () -> {

                            });
                        });

                        nodeProduce(Items.coal, () -> {
                            nodeProduce(Items.graphite, () -> {
                                nodeProduce(Items.silicon, () -> {

                                });
                            });

                            nodeProduce(Items.pyratite, () -> {
                                nodeProduce(Items.blastCompound, () -> {

                                });
                            });

                            nodeProduce(Items.sporePod, () -> {

                            });

                            nodeProduce(Liquids.oil, () -> {
                                nodeProduce(Items.plastanium, () -> {

                                });
                            });
                        });
                    });
                });
            });
        });
    }
}
   /*
         node(多重编织机,  ItemStack.with(铁,20), Seq.with(
                    new Objectives.Research(phaseWeaver),//研究
                    new Objectives.SectorComplete(地图名)//占领
            ),() -> {
                //子类
            });
            */

