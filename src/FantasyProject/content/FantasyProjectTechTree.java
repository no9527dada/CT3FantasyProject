package FantasyProject.content;

import arc.Core;
import arc.struct.Seq;
import mindustry.game.Objectives;

import static FantasyProject.content.FantasyProjectDefense.*;
import static FantasyProject.content.FantasyProjectDrill.*;
import static FantasyProject.content.FantasyProjectGenericCrafter.*;
import static FantasyProject.content.FantasyProjectItems.钴;
import static FantasyProject.content.FantasyProjectItems.镍;
import static FantasyProject.content.FantasyProjectMaps.*;

import static FantasyProject.content.FantasyProjectPlanet.FantasyPlanet;
import static FantasyProject.content.FantasyProjectPower.*;
import static FantasyProject.content.FantasyProjectTurrets.*;
import static FantasyProject.content.FantasyProjectUnits.*;
import static FantasyProject.content.FantasyProjectWuLiu.*;
import static ct.Asystem.type.CTTechTree.addToTree;


import static mindustry.content.Blocks.*;
import static mindustry.content.Items.plastanium;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;


public class FantasyProjectTechTree {
    public static float TechTrees5倍率 = 1;

    public static void load() {
        FantasyPlanet.techTree = nodeRoot(Core.bundle.format("FantasyPlanetTT"), coreShard, true, () -> {

        /*
         node(多重编织机,  ItemStack.with(铁,20), Seq.with(
                    new Objectives.Research(phaseWeaver),
                    new Objectives.SectorComplete(地图名)
            ),() -> {
                //子类
            });
            */


            //工厂
            node(石英提取机, () -> {
                node(铁锻造机, Seq.with(new Objectives.Research(mechanicalDrill)), () -> {
                    node(石英磨练机, () -> {
                        node(多重冶炼厂, Seq.with(new Objectives.Research(siliconSmelter)), () -> {
                            node(大型培养机, Seq.with(new Objectives.Research(cultivator)), () -> {
                            });
                            node(碳板压缩机, Seq.with(new Objectives.Research(multiPress)), () -> {
                            });
                        });

                    });
                    node(空壳制造机, Seq.with(new Objectives.Research(multiPress)), () -> {
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
                    node(合金锤炼厂, Seq.with(new Objectives.Research(surgeSmelter)), () -> {
                        node(钻石提炼机, () -> {
                            node(钻石矿加工厂, () -> {
                            });
                        });
                        node(钻石混合物反应机, () -> {
                            node(多重编织机, Seq.with(new Objectives.Research(phaseWeaver)), () -> {
                            });
                            node(多重塑钢机, Seq.with(new Objectives.Research(plastaniumCompressor)), () -> {
                            });
                            node(钻石提炼机, () -> {
                            });
                            node(相织反应炉, () -> {
                            });
                        });
                        node(啸动冶炼机, () -> {
                            node(军火材料机, () -> {
                                node(军火库, () -> {
                                });
                                node(水晶复合器, () -> {
                                });
                            });
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
                            node(镍板混合器, () -> {
                            });
                            node(钛合金反应炉, () -> {
                            });
                        });
                    });
                    node(铁板锻造机, () -> {
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
            });
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
                node(毁灭, () -> {
                    node(魄散, () -> {
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
                    node(终焉, () -> {
                        node(尘埃, () -> {
                        });
                    });

                });
            });
            //电力
            node(火能发电机, Seq.with(new Objectives.Research(thermalGenerator)), () -> {
                node(汽轮发电机, () -> {
                    node(连接终端, Seq.with(new Objectives.Research(surgeTower)), () -> {
                        node(超大型电池, Seq.with(new Objectives.Research(batteryLarge)), () -> {
                            node(充能水晶, () -> {
                            });
                        });
                        node(充能节点, () -> {
                        });
                    });
                    node(超大型太阳能板, Seq.with(new Objectives.Research(largeSolarPanel)), () -> {
                    });
                    node(超级rtg发电机, Seq.with(new Objectives.Research(thermalGenerator)), () -> {
                        node(地水发电机, () -> {
                            node(地水触及机, () -> {
                            });
                            node(地引发电机, () -> {
                            });
                        });
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
            node(零号, () -> {
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
    }
}
