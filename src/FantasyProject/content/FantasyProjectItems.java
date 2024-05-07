package FantasyProject.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.world.blocks.environment.OreBlock;

import static ct.content.ItemX.物品;
import static mindustry.content.Items.*;

//方块
public class FantasyProjectItems {
    public static final Seq<Item>
            mod资源5显示 = new Seq<>();
    public static OreBlock ore钻石混合物, ore石英, ore镍, ore钴;
    public static Item
            爆破弹, 放射混合物, 钴, 固体放射物, 金, 空壳, 冷冻弹, 钻石矿,
            黎辉水晶, 镍, 镍板, 石英, 水瓶, 碎裂弹, 钛合金, 碳板, 铁, 铁板, 液电池, 相织硅,
            啸动合金, 硬直弹, 钻石, 钻石混合物;
    public static Item
            铜, 铅, 石墨, 玻璃, 硅, 钛, 钍, 塑钢, 布, 合金;
    public static Liquid
            制冷液, 辐射混合物, 啸冷剂, 军用液体;

    public static void load() {
        铜 = copper;
        铅 = lead;
        石墨 = graphite;
        玻璃 = metaglass;
        硅 = silicon;
        钛 = titanium;
        钍 = thorium;
        塑钢 = plastanium;
        布 = phaseFabric;
        合金 = surgeAlloy;
        石英 = new Item("石英", Color.valueOf("F5F5F5")) {{

            hardness = 3;

        }};
        碳板 = new Item("碳板", Color.valueOf("696969")) {{

            flammability = 3.8f;
            explosiveness = 0.3f;

        }};
        铁 = new Item("铁", Color.valueOf("F8F8FF"));
        铁板 = new Item("铁板", Color.valueOf("DCDCDC"));
        钴 = new Item("钴", Color.valueOf("4169E1")) {{
            localizedName = "钴";
            hardness = 5;
        }};
        镍 = new Item("镍", Color.valueOf("008B8B")) {{
            hardness = 6;
        }};
        镍板 = new Item("镍板", Color.valueOf("2E8B57"));
        钻石混合物 = new Item("钻石混合物", Color.valueOf("008B8B")) {{
            flammability = 1.5945f;
        }};
        钻石 = new Item("钻石", Color.valueOf("00F5FF")) {{
            flammability = 2.234f;
            //explosiveness=0.3f;
        }};
        钻石矿 = new Item("钻石矿", Color.valueOf("008B8B")) {{
            hardness = 6;
            flammability = 1.5945f;
        }};
        相织硅 = new Item("相织硅", Color.valueOf("FFDAB9")) {{
            radioactivity = 1.2F;
        }};
        金 = new Item("金", Color.valueOf("CD950C"));
        钛合金 = new Item("钛合金", Color.valueOf("7AC5CD"));

        空壳 = new Item("空壳", Color.valueOf("FFF8DC"));
        液电池 = new Item("液电池", Color.valueOf("87CEFF")) {{
            radioactivity = 1.4F;
            flammability = 0.3f;
        }};
        水瓶 = new Item("水瓶", Color.valueOf("1E90FF"));
        冷冻弹 = new Item("冷冻弹", Color.valueOf("87CEEB"));
        碎裂弹 = new Item("碎裂弹", Color.valueOf("BDB76B"));
        爆破弹 = new Item("爆破弹", Color.valueOf("CD5555")) {{
            hardness = 2;
            explosiveness = 2;
            flammability = 0.3F;
        }};
        硬直弹 = new Item("硬直弹", Color.valueOf("8B7D7B")) ;

        放射混合物 = new Item("放射混合物", Color.valueOf("FF6A6A")) {{
            radioactivity = 1.5F;
            flammability = 0.3f;
        }};
        固体放射物 = new Item("固体放射物", Color.valueOf("CD950C")) {{
            radioactivity = 10F;
            flammability = 0.5f;
        }};
        啸动合金 = new Item("啸动合金", Color.valueOf("FFFF00"));
        黎辉水晶 = new Item("黎辉水晶", Color.valueOf("FFFF00"));


        辐射混合物 = new Liquid("辐射混合物", Color.valueOf("FFC125")) {{
            temperature = 0.8f;
            viscosity = 0.6f;
            flammability = heatCapacity = explosiveness = 0;
            lightColor = Color.valueOf("FFC125").a(0.2f);
        }};
        制冷液 = new Liquid("制冷液", Color.valueOf("00BFFF")) {{
            temperature = 0f;
            viscosity = 0.8f;
            flammability = 0f;
            heatCapacity = 1.5f;
            explosiveness = 0;
            lightColor = Color.valueOf("6ddaff").a(0.2f);
        }};

        军用液体 = new Liquid("军用液体", Color.valueOf("F7F7F7")) {{
            temperature = 5.0f;
            viscosity = 0f;
            flammability = 0.3f;
            heatCapacity = 0;
            explosiveness = 5;
        }};
        啸冷剂 = new Liquid("啸冷剂", Color.valueOf("18A044")) {{
            temperature = 0f;
            viscosity = 0.5f;
            flammability = 0f;
            heatCapacity = 4;
            explosiveness = 0;
            lightColor = Color.valueOf("5afe8f").a(0.2f);
        }};


        ore钴 = new OreBlock(钴) {{
            variants = 3;
            oreDefault = true;
            oreThreshold = 0.86f;
            oreScale = 17.46f;
        }};
        ore镍 = new OreBlock(镍) {{
            variants = 3;
            oreDefault = true;
            oreThreshold = 0.8f;
            oreScale = 22.45f;
        }};
        ore石英 = new OreBlock(石英) {{
            variants = 3;
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 19.96f;
        }};
        ore钻石混合物 = new OreBlock(钻石矿) {{
            variants = 3;
            oreDefault = true;
            oreThreshold = 0.86f;
            oreScale = 22.45f;
        }};

        mod资源5显示.addAll(
                scrap, copper, lead, graphite, coal, titanium, thorium, silicon, plastanium,
                phaseFabric, surgeAlloy, sporePod, sand, blastCompound, pyratite, metaglass,
                爆破弹, 放射混合物, 钴, 固体放射物, 金, 空壳, 冷冻弹, 钻石矿,
                黎辉水晶, 镍, 镍板, 石英, 水瓶, 碎裂弹, 钛合金, 碳板, 铁, 铁板, 液电池, 相织硅,
                啸动合金, 硬直弹, 钻石, 钻石混合物, 物品
        );
    }
}