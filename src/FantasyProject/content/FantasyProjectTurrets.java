package FantasyProject.content;


import CtCoreSystem.CoreSystem.type.Ovulam5480.BulletType.CT3LaserBulletType;
import CtCoreSystem.CoreSystem.type.Ovulam5480.BulletType.CT3PaiBulletType;
import CtCoreSystem.CoreSystem.type.Ovulam5480.GuDingTurret;
import CtCoreSystem.content.Effect.NewEffect;
import CtCoreSystem.content.Effect.NewFx;
import CtCoreSystem.content.NewColor;
import arc.Core;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Angles;
import arc.util.Time;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootHelix;
import mindustry.entities.pattern.ShootPattern;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.StatusEffect;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.draw.DrawTurret;

import static CtCoreSystem.CoreSystem.CT3Sound.loadSound;
import static CtCoreSystem.content.NewColor.制裁Bullet颜色;
import static CtCoreSystem.content.NewColor.尘埃Bullet颜色1;
import static FantasyProject.content.FantasyProjectItems.*;
import static mindustry.content.Fx.shootBig;
import static mindustry.content.Fx.shootSmallSmoke;
import static mindustry.content.Items.*;
import static mindustry.gen.Sounds.*;
import static mindustry.type.ItemStack.with;

//unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
//方块
public class FantasyProjectTurrets {
    public static Block 真双管炮, 咻咻炮, 制裁, 灭亡, 毁灭, 散射炮,
            追动, 光棱塔, 超级光棱塔, 起源, 皇后, 帝王, 空之驱逐, 空中祸害,
            魂灭, 魄散, 排山, 尘埃, 终焉,
            炮塔aaa;

    public static void load() {

        真双管炮 = new ItemTurret("真双管炮") {{
            //localizedName = Core.bundle.get("Turret.真双管炮");
            requirements(Category.turret, with(Items.copper, 35, graphite, 10));
            ammo(
                    Items.copper, new BasicBulletType(2.5f, 18) {{
                        width = 10f;
                        height = 13f;
                        lifetime = 90f;
                        ammoMultiplier = 2;
                    }},
                    graphite, new BasicBulletType(3.5f, 25) {{
                        width = 10f;
                        height = 13f;
                        reloadMultiplier = 0.6f;
                        ammoMultiplier = 4;
                        lifetime = 90f;
                    }},
                    Items.silicon, new BasicBulletType(4f, 33) {{
                        width = 10f;
                        height = 13f;
                        homingPower = 0.1f;
                        reloadMultiplier = 1.5f;
                        ammoMultiplier = 5;
                        lifetime = 90f;
                    }},
                    石英, new BasicBulletType(4f, 20) {{
                        width = 11f;
                        height = 13f;
                        homingPower = 0.1f;
                        reloadMultiplier = 1.5f;
                        ammoMultiplier = 5;
                        lifetime = 90f;
                        knockback = 1;
                    }}
            );

            shoot = new ShootAlternate(3.5f);
            // shoot.shotDelay = 5f;
            shoot.shots = 2;
            recoils = 2;
            drawer = new DrawTurret() {{
                for (int i = 0; i < 2; i++) {
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")) {{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -1.5f;
                    }});
                }
            }};

            recoil = 0.5f;
            shootY = 3f;
            reload = 20f;
            range = 230;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 400;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            researchCostMultiplier = 0.05f;

            limitRange();
        }};
        咻咻炮 = new ItemTurret("咻咻炮") {{
            int 咻咻炮lifetime = 70;
            //localizedName = Core.bundle.get("Turret.咻咻炮");
            health = 800;
            size = 2;
            shoot.shots = 4;
            shoot.shotDelay = 2;
            targetGround = targetAir = true;
            range = 210;
            inaccuracy = 5;
            recoil = 2;//后座力动画
            reload = 20;//射速
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);//液体使用量
            ammo(
                    copper, new BasicBulletType() {{
                        speed = 3;
                        damage = 15;
                        width = 11;
                        height = 10;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 2;
                        reloadMultiplier = 1.0f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    铁, new BasicBulletType() {{
                        speed = 3.5f;
                        damage = 30;

                        width = 15;
                        height = 10;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 3;
                        reloadMultiplier = 1.3f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    石英, new BasicBulletType() {{
                        speed = 3.5f;
                        damage = 18;
                        width = 11;
                        height = 10;
                        // pierce = true;//穿透
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 4;
                        reloadMultiplier = 1.2f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    silicon, new BasicBulletType() {{
                        speed = 3.5f;
                        damage = 22;
                        width = 15;
                        //pierce = true;
                        height = 10;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 2;
                        reloadMultiplier = 1.2f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    graphite, new BasicBulletType() {{
                        speed = 5;
                        damage = 20;
                        width = 11;
                        height = 10;
                        // pierce = true;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 1;
                        reloadMultiplier = 0.8f;
                        lifetime = 咻咻炮lifetime;
                    }},
                    硬直弹, new BasicBulletType() {{
                        speed = 3;
                        damage = 52;
                        width = 13;
                        height = 11;
                        shootEffect = shootBig;
                        smokeEffect = shootSmallSmoke;
                        ammoMultiplier = 3;
                        reloadMultiplier = 1.3f;
                        lifetime = 咻咻炮lifetime;
                    }}
            );
            requirements(Category.turret, with(石英, 60, Items.copper, 35, silicon, 150));
        }};

        制裁 = new ItemTurret("制裁") {
            {
                //localizedName = Core.bundle.get("Turret.制裁");
                requirements(Category.turret, with(
                        石英, 300,
                        copper, 320,
                        lead, 320,
                        铁, 80,
                        钍, 150
                ));

                health = 1700;
                size = 3;
                //shoot.shots = 4;
                // shoot.shotDelay=2;
                targetGround = targetAir = true;
                range = 330;
                inaccuracy = 2;
                recoil = 2;//后座力动画
                reload = 5;//射速
                rotateSpeed = 10f;
                ammoUseEffect = NewFx.子弹抛壳(3, 20, Color.valueOf("27bbf3"), 制裁Bullet颜色, Pal.lightishGray);//弹壳脱壳动画效果
                shootSound = loadSound("制裁");
                ammo(
                        copper, new FantasyProjectBullets.制裁Bullet(40, 25, 10),
                        lead, new FantasyProjectBullets.制裁Bullet(40, 23, 10),
                        silicon, new FantasyProjectBullets.制裁Bullet(70, 33, 6) {{
                            reloadMultiplier = 0.8f;
                            homingPower = 1;
                            homingRange = 60;
                        }},

                        graphite, new FantasyProjectBullets.制裁Bullet(40, 30, 10) {{
                            reloadMultiplier = 0.7f;
                        }},
                        titanium, new FantasyProjectBullets.制裁Bullet(40, 30, 10) {{
                            reloadMultiplier = 1.5f;
                        }},
                        钍, new FantasyProjectBullets.制裁Bullet(40, 30, 10) {{
                            reloadMultiplier = 1.5f;
                        }},
                        碎裂弹, new FantasyProjectBullets.制裁Bullet(40, 45, 10) {{
                            ammoMultiplier = 10;
                            reloadMultiplier = 0.8f;
                            pierce = false;
                            despawnEffect = Fx.none;
                            hitEffect = Fx.blastExplosion;
                            fragBullet = new BasicBulletType(2.5f, 20, "bullet") {{
                                width = 10f;
                                height = 12f;
                                shrinkY = 1f;
                                lifetime = 15f;
                                backColor = Pal.plastaniumBack;
                                frontColor = Pal.plastaniumFront;
                                hitEffect = despawnEffect = Fx.none;
                                pierce = true;
                            }};
                            fragBullets = 10;
                        }},
                        硬直弹, new FantasyProjectBullets.制裁Bullet(40, 90, 10) {{
                            ammoMultiplier = 10;
                            status = StatusEffects.electrified;
                            statusDuration = 30;
                        }},
                        冷冻弹, new FantasyProjectBullets.制裁Bullet(40, 20, 10) {{
                            reloadMultiplier = 0.3f;
                            pierce = true;
                            status = StatusEffects.freezing;
                            statusDuration = 60;
                        }}

                );
            }
        };


        灭亡 = new ItemTurret("灭亡") {
            {
                //localizedName = Core.bundle.get("Turret.灭亡");
                requirements(Category.turret, with(
                        石英, 300,
                        copper, 320,
                        lead, 320,
                        铁, 200,
                        surgeAlloy, 125,
                        graphite, 250
                ));

                health = 4000;
                size = 4;
                targetGround = targetAir = true;
                range = 43 * 8;
                inaccuracy = 0;
                recoil = 5;//后座力动画
                reload = 11;//射速
                rotateSpeed = 10f;
                shootSound = Sounds.shootToxopidShotgun;
                ammoUseEffect = NewFx.子弹抛壳2(5, 50, Pal.lightOrange, Pal.lightishGray, Pal.lightishGray);//弹壳脱壳动画效果
                shoot = new ShootAlternate() {{
                    spread = 15;
                    shots = 2;
                    barrels = 2;
                }};
                xRand = 2;
                shootCone = 40;
                maxAmmo = 10;
                // ammoUseEffect = Fx.casing3;
                ammo(
                        copper, new FantasyProjectBullets.灭亡Bullet(70, 60, 7, 1.1f, 1),
                        钛, new FantasyProjectBullets.灭亡Bullet(70, 90, 7, 1, 2),
                        钍, new FantasyProjectBullets.灭亡Bullet(70, 120, 7, 1.2f, 2),
                        钴, new FantasyProjectBullets.灭亡Bullet(70, 180, 9, 1.2f, 4),
                        爆破弹, new FantasyProjectBullets.灭亡Bullet(70, 360, 9, 1.3f, 8){{ status = StatusEffects.blasted;statusDuration=120;}},
                        铁板, new FantasyProjectBullets.灭亡Bullet(70, 270, 7, 1f, 8) {{
                            width = height = 30;status = StatusEffects.sapped;//弱化
                            statusDuration = 30;
                        }},
                        graphite, new FantasyProjectBullets.灭亡Bullet(70, 60, 7, 1.3f, 2) {{
                            width = 15;
                            height = 30;
                        }}
                );
            }
        };

        毁灭 = new ItemTurret("毁灭") {
            {
                //localizedName = Core.bundle.get("Turret.毁灭");

                requirements(Category.turret, with(
                        石英, 320,
                        镍板, 60,
                        铁, 150,
                        相织硅, 20,
                        合金, 90
                ));
                health = 5500;
                size = 4;
                // shootSound = Sounds.shootArtillery;
                shootSound = loadSound("毁灭");
                xRand = 2;
                shootCone = 40;
                maxAmmo = 15;

                targetGround = targetAir = true;
                range = 55 * 8;
                inaccuracy = 0;
                recoil = 5;//后座力动画
                reload = 130;//射速
                // shoot.shots = 2;
                // shoot.shotDelay=30;
                rotateSpeed = 10f;

                float dhang = 1.5f;
                ammo(

                        graphite, new FantasyProjectBullets.毁灭Bullet(100, 150 * dhang, 5, 1.5f, 1),
                        thorium, new FantasyProjectBullets.毁灭Bullet(100, 360 * dhang, 5, 1.2f, 1),
                        surgeAlloy, new FantasyProjectBullets.毁灭Bullet(100, 666 * dhang, 5, 1.5f, 2),
                        钴, new FantasyProjectBullets.毁灭Bullet(100, 666 * dhang, 5, 0.9f, 1),
                        硬直弹, new FantasyProjectBullets.毁灭Bullet(100, 1600 * dhang, 5, 1f, 4),
                        钻石, new FantasyProjectBullets.毁灭Bullet(100, 1100 * dhang, 5, 1f, 1),
                        铁板, new FantasyProjectBullets.毁灭Bullet(100, 720 * dhang, 5, 1.3f, 2),
                        镍板, new FantasyProjectBullets.毁灭Bullet(100, 900 * dhang, 5, 1.3f, 4)
                );
            }
        };

        散射炮 = new ItemTurret("散射炮") {
            {
                //localizedName = Core.bundle.get("Turret.散射炮");

                requirements(Category.turret, with(
                        石英, 20,
                        metaglass, 45,
                        铁, 5
                ));
                shootCone = 40;

                inaccuracy = 0;
                recoil = 7;//后座力动画
                reload = 40;//射速
                //shoot.shots = 2;
                // shoot.shotDelay=30;
                shoot = new ShootSpread(7, 10f);
                rotateSpeed = 10f;
                health = 1200;
                size = 2;
                targetAir = true;
                targetGround = false;
                range = 36 * 8;
                ammo(
                        lead, new FantasyProjectBullets.散射炮Bullet(17, 15, 30, 1f, 1),
                        sand, new FantasyProjectBullets.散射炮Bullet(17, 12, 18, 1f, 1),
                        石英, new FantasyProjectBullets.散射炮Bullet(17, 20, 23, 1.2f, 2),
                        metaglass, new FantasyProjectBullets.散射炮Bullet(17, 18, 25, 1.2f, 1),
                        graphite, new FantasyProjectBullets.散射炮Bullet(17, 20, 35, 1f, 1),
                        钛, new FantasyProjectBullets.散射炮Bullet(17, 35, 30, 1.2f, 1),
                        钍, new FantasyProjectBullets.散射炮Bullet(17, 45, 18, 1.4f, 1),
                        silicon, new FantasyProjectBullets.散射炮Bullet(17, 20, 32, 1.3f, 2)
                );
            }
        };
        追动 = new ItemTurret("追动") {
            {
                //localizedName = Core.bundle.get("Turret.追动");

                requirements(Category.turret, with(
                        石英, 50,
                        copper, 145,
                        铁, 30
                ));
                shootCone = 40;
                //consumePower(90 / 60f);
                recoil = 7;//后座力动画
                reload = 63;//射速
                shoot.shots = 5;
                shoot.shotDelay = 5;
                rotateSpeed = 10f;
                targetAir = false;
                targetGround = true;
                health = 1800;
                size = 3;
                shootSound = Sounds.shootMissile;
                range = 42*8;
                inaccuracy = 5;
                ammoPerShot = 4;
                ammo(
                        钍, new FantasyProjectBullets.追动Bullet(30, 28, 15, 1.2f, 4),
                        铁, new FantasyProjectBullets.追动Bullet(30, 38, 15, 1.2f, 4),
                        graphite, new FantasyProjectBullets.追动Bullet(30, 25, 15, 1f, 2),
                        sand, new FantasyProjectBullets.追动Bullet(30, 12, 15, 1.5f, 1),
                        coal, new FantasyProjectBullets.追动Bullet(30, 15, 15, 1.3f, 1),
                        冷冻弹, new FantasyProjectBullets.追动Bullet(30, 20, 15, 1.5f, 4) {{
                            status = StatusEffects.freezing;
                            statusDuration = 15;
                        }},

                         /*       碳板, new FantasyProjectBullets.追动Bullet(200, 15, 3, 1f, 4) {{
                                    sprite = "ct-baojian";
                                    height = 40;
                                    width = 12;
                                    homingPower = 0.00769f;
                                    homingRange = 38;
                                }},*/


                        lead, new FantasyProjectBullets.追动Bullet(20, 20, 15, 1.2f, 1),
                        copper, new FantasyProjectBullets.追动Bullet(20, 20, 15, 1.2f, 1)
                );
            }
        };

        光棱塔 = new PowerTurret("光棱塔") {
            {
                //localizedName = Core.bundle.get("Turret.光棱塔");

                requirements(Category.turret, with(
                        copper, 750,
                        lead, 700,
                        合金, 130,
                        液电池, 125,
                        镍板, 80
                ));

                drawer = NewFx.光棱塔蓄力射击效果();
                //充能声音
                chargeSound = Vars.tree.loadSound("光棱充能2");
                shoot.firstShotDelay = 40f;
                shootEffect = Fx.lancerLaserShoot;

                smokeEffect = new NewEffect.BulletWaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 20f;
                    //持续时间
                    lifetime = 20;
                    strokeFrom = 2f;
                    strokeTo = 0f;
                    colorFrom = NewColor.光棱塔Bullet1;
                    colorTo = NewColor.光棱塔Bullet2;
                }};
                heatColor = Color.red;
                shootCone = 30;
                inaccuracy = 0;
                recoil = 7;//后座力动画
                reload = 120;//射速
                //shoot.shots = 2;
                // shoot.shotDelay=30;
                //shoot = new ShootSpread(7, 10f);
                rotateSpeed = 10f;
                targetGround = targetAir = true;
                health = 4500;
                size = 5;
                range = 85 * 8;
                consumePower(1400 / 60f);
                coolant = consumeCoolant(0.1f);
                shootSound = Vars.tree.loadSound("光棱");
                // ammoUseEffect=Fx.shellEjectSmall;//使用弹药时产生的效果。
                shootType = new FantasyProjectBullets.光棱塔Bullet(2400);
            }
        };


        超级光棱塔 = new PowerTurret("超级光棱塔") {
            {
                //localizedName = Core.bundle.get("Turret.超级光棱塔");

                requirements(Category.turret, with(
                        copper, 3750,
                        lead, 3700,
                        碳板, 220,
                        液电池, 480,
                        相织硅, 500,
                        镍板, 320,
                        啸动合金, 50
                ));

                drawer = NewFx.超级光棱塔蓄力射击效果();
                //充能声音
                chargeSound = Vars.tree.loadSound("光棱充能2");
                shoot.firstShotDelay = 40f;
                shootEffect = Fx.lancerLaserShoot;
                smokeEffect = new NewEffect.BulletWaveEffect() {{
                    sizeFrom = 0f;
                    sizeTo = 20f;
                    //持续时间
                    lifetime = 20;
                    strokeFrom = 2f;
                    strokeTo = 0f;
                    colorFrom = NewColor.光棱塔Bullet1;
                    colorTo = NewColor.光棱塔Bullet2;
                }};
                heatColor = Color.red;
                shootCone = 30;

                inaccuracy = 0;
                recoil = 15;//后座力动画
                reload = 180;//射速
                //shoot.shots = 2;
                // shoot.shotDelay=30;
                //shoot = new ShootSpread(7, 10f);
                rotateSpeed = 2f;
                targetGround = targetAir = true;
                health = 7000;
                size = 8;
                range = 130 * 8;
                consumePower(4500 / 60f);
                coolant = consumeCoolant(0.1f);
                shootSound = Vars.tree.loadSound("光棱");
                // ammoUseEffect=Fx.shellEjectSmall;//使用弹药时产生的效果。
                shootType = new FantasyProjectBullets.超级光棱塔Bullet(4800);
            }
        };
        起源 = new ItemTurret("起源") {
            {
                //localizedName = Core.bundle.get("Turret.起源");

                requirements(Category.turret, with(
                        copper, 300,
                        液电池, 100,
                        镍板, 80,
                        钴, 100,
                        石英, 150,
                        lead, 320
                ));

                shootSound = Sounds.shootDiffuse;
                drawer = NewFx.起源装弹效果();
                size = 4;
                maxAmmo = 32;
                coolantMultiplier = 1.5f;//液体单位量
                // ammoPerShot = 4;//每发消耗的资源
                recoil = 7;//后座力动画
                reload = 240;//射速
                shoot.firstShotDelay = 60f;
                health = 3500;
                range = 70 * 8;
                shootSound = Sounds.shootArtillery;
                unitSort = UnitSorts.farthest;//最远
                consumePower(2300 / 60f);
                ammo(
                        冷冻弹, new FantasyProjectBullets.起源Bullet(33, 4, 300) {{
                            status = StatusEffects.freezing;
                            statusDuration = 20;
                        }},
                        液电池, new FantasyProjectBullets.起源Bullet(60, 3, 750) {{
                            status = StatusEffects.electrified;
                            statusDuration = 30;
                        }},
                        钻石, new FantasyProjectBullets.起源Bullet(100, 4, 1000),
                        硬直弹, new FantasyProjectBullets.起源Bullet(140, 5, 1600) {{
                            status = StatusEffects.electrified;
                            statusDuration = 30;
                        }}
                );

            }
        };
        皇后 = new ItemTurret("皇后") {
            {
                //localizedName = Core.bundle.get("Turret.皇后");

                requirements(Category.turret, with(
                        石英, 200,
                        金, 150,
                        graphite, 80,
                        塑钢, 60,
                        copper, 150,
                        lead, 180
                ));

                shootSound = Sounds.shootDiffuse;
                drawer = NewFx.皇后装弹效果();
                size = 4;
                //  maxAmmo=32;
                coolantMultiplier = 1.5f;//液体单位量
                // ammoPerShot = 4;//每发消耗的资源
                recoil = 7;//后座力动画
                reload = 240;//射速
                shoot.firstShotDelay = 60f;
                health = 2400;
                range = 56 * 8;
                shoot = new ShootHelix() {{
                    mag = 3.5f;
                    scl = 7f;
                }};

                rotateSpeed = 2f;
                shoot.shots = 5;
                shoot.shotDelay = 6;
                int fff = 2;
                ammo(
                        金, new FantasyProjectBullets.皇后Bullet(120f / fff, 4, 3, 1.5F, 4),
                        铁, new FantasyProjectBullets.皇后Bullet(100F / fff, 4, 3, 1.2F, 4),
                        thorium, new FantasyProjectBullets.皇后Bullet(90f / fff, 1, 3, 1, 2),
                        blastCompound, new FantasyProjectBullets.皇后Bullet(110f / fff, 3, 3, 1.2F, 3),
                        钻石, new FantasyProjectBullets.皇后Bullet(180f / fff, 6, 3.2f, 1, 5),
                        钴, new FantasyProjectBullets.皇后Bullet(150f / fff, 2, 3f, 1.7F, 5),
                        爆破弹, new FantasyProjectBullets.皇后Bullet(280, 5, 3.5f, 1.3F, 6) {{
                            status = StatusEffects.electrified;
                            statusDuration = 60;
                        }}
                );
            }
        };
        帝王 = new ItemTurret("帝王") {
            {
                //localizedName = Core.bundle.get("Turret.帝王");

                requirements(Category.turret, with(
                        copper, 300,
                        液电池, 100,
                        钻石, 80,
                        钴, 100,
                        石英, 150,
                        lead, 320
                ));

                shootSound = Sounds.shootDiffuse;
                drawer = NewFx.帝王装弹效果();
                size = 4;
                maxAmmo = 32;
                coolantMultiplier = 1.5f;//液体单位量
                // ammoPerShot = 4;//每发消耗的资源
                recoil = 7;//后座力动画
                reload = 50;//射速
                shoot.firstShotDelay = 20f;
                health = 3500;
                range = 56 * 8 * 2;
                ammo(thorium, new FantasyProjectBullets.帝王Bullet(80, 45, 3, 20, 1.3f),
                        铁, new FantasyProjectBullets.帝王Bullet(130, 55, 4, 20, 1),
                        镍, new FantasyProjectBullets.帝王Bullet(150, 70, 4, 20, 1.3f),
                        钛合金, new FantasyProjectBullets.帝王Bullet(120, 50, 5, 20, 2) {{
                            knockback = 3;
                        }},
                        钻石, new FantasyProjectBullets.帝王Bullet(220, 120, 4, 20, 1),
                        碎裂弹, new FantasyProjectBullets.帝王Bullet(190, 105, 5, 20, 1),
                        冷冻弹, new FantasyProjectBullets.帝王Bullet(130, 80, 3, 20, 1) {{
                            status = StatusEffects.freezing;
                            statusDuration = 120;
                        }},
                        硬直弹, new FantasyProjectBullets.帝王Bullet(250, 130, 5, 20, 1) {{
                            status = StatusEffects.electrified;
                            statusDuration = 30;
                        }},
                        啸动合金, new FantasyProjectBullets.帝王Bullet(900, 4500, 8, 20, 1.5f)
                );
            }
        };

        StatusEffect 冷冻 = new StatusEffect("lengdong") {{
            reloadMultiplier = 0.7f;//射击速度
            speedMultiplier = 0.4f;//移速
            localizedName ="射速70%，移速40%";
        }};
        空之驱逐 = new ItemTurret("空之驱逐") {
            {
                //localizedName = Core.bundle.get("Turret.空之驱逐");

                requirements(Category.turret, with(
                        copper, 500,
                        lead, 700,
                        thorium, 150,
                        石英, 125,
                        铁, 80,
                        金, 70,
                        合金, 70
                ));
                targetAir = true; //空
                targetGround = false; //地
                // shootSound = Sounds.shootDiffuse;
                // drawer = NewFx.帝王装弹效果();
                inaccuracy = 10;//精度
                size = 5;
                coolantMultiplier = 1.5f;//液体单位量
                maxAmmo = 66;
                // ammoPerShot = 4;//每发消耗的资源
                recoil = 3;//后座力动画
                reload = 7;//射速
                shoot.firstShotDelay = 120f;
                health = 3500;
                range = 63 * 8;
                consumePower(700 / 60f);
                // shoot = new ShootSpread(10, 30f);//射击数量，角度
                shoot = new ShootAlternate(15f);
                  /*      shoot = new ShootAlternate() {{
                            spread = 15;
                            shots = 2;
                            barrels = 2;
                        }};*/
                // shoot.shotDelay=reload/5;
                ammo(
                        thorium, new FantasyProjectBullets.空之驱逐Bullet(90, 3, 9, 1f, 3),
                        metaglass, new FantasyProjectBullets.空之驱逐Bullet(40, 5, 9, 1.5f, 1),
                        plastanium, new FantasyProjectBullets.空之驱逐Bullet(140, 6, 9, 1.2f, 3),
                        碎裂弹, new FantasyProjectBullets.空之驱逐Bullet(0, 4, 9, 1.4f, 4) {{
                            splashDamage = 200;//范围伤害
                            splashDamageRadius = 8 * 8;//范围伤害的范围
                        }},
                        冷冻弹, new FantasyProjectBullets.空之驱逐Bullet(70, 3, 9, 0.5f, 1) {{
                            status = 冷冻;
                            statusDuration = 60;
                            splashDamageRadius = 8 * 60; //伤害范围
                            splashDamage = 0; //范围伤害的伤害
                        }},
                        金, new FantasyProjectBullets.空之驱逐Bullet(120, 6, 9, 2f, 6),
                        铁板, new FantasyProjectBullets.空之驱逐Bullet(420, 8, 9, 1f, 5),
                        钛合金, new FantasyProjectBullets.空之驱逐Bullet(350, 10, 9, 1f, 4),
                        合金, new FantasyProjectBullets.空之驱逐Bullet(270, 4, 9, 1f, 3){{
                            lightning = 3;
                            lightningDamage = 12;
                            lightningLength = 8;
                        }},
                        液电池, new FantasyProjectBullets.空之驱逐Bullet(180, 3, 9, 1.1f, 3) {{
                            status = StatusEffects.shocked;
                            statusDuration = 60;
                            splashDamageRadius = 8 * 8; //伤害范围
                            splashDamage = 0; //范围伤害的伤害
                        }},
                        水瓶, new FantasyProjectBullets.空之驱逐Bullet(60, 3, 9, 1f, 0) {{
                            status = StatusEffects.wet;
                            statusDuration = 60;
                            splashDamageRadius = 8 * 8; //伤害范围
                            splashDamage = 0; //范围伤害的伤害
                        }}
                );
            }
        };
        空中祸害 = new ItemTurret("空中祸害") {
            {
                requirements(Category.turret, with(
                        copper, 4500,
                        lead, 4300,
                        液电池, 340,
                        镍板, 280,
                        钴, 700,
                        石英, 350,
                        钻石, 300,
                        相织硅, 130,
                        啸动合金, 30

                ));
                unitSort = UnitSorts.strongest;//攻击单位时的优先选择/closest/farthest/strongest/weakest
                consumePower(6500 / 60f);
                targetAir = true; //空
                targetGround = false; //地
                shootSound = Sounds.shootToxopidShotgun;
                // drawer = NewFx.帝王装弹效果();
                inaccuracy = 13;//精度
                size = 10;
                maxAmmo = 90;
                coolantMultiplier = 1.5f;//液体单位量
                ammoPerShot = 4;//每发消耗的资源
                recoil = 7;//后座力动画
                reload = 300;//射速
                shoot.firstShotDelay = 300;//第一次射击延迟
                shoot = new ShootPattern() {
                    {
                        shots = 5;
                        // firstShotDelay=0;
                        shotDelay = 7;
                    }
                };
                        /*         shoot = new ShootAlternate() {{
                            spread = 30;
                            shots = 4;
                            barrels = 2;
                        }};*/
                health = 3500;
                range = 130 * 8;
                ammo(thorium, new FantasyProjectBullets.空中祸害Bullet(90, 4, 9, 1f, 3),
                        metaglass, new FantasyProjectBullets.空中祸害Bullet(40, 2, 9, 1.5f, 1),
                        plastanium, new FantasyProjectBullets.空中祸害Bullet(140, 4, 9, 1.2f, 3),
                        碎裂弹, new FantasyProjectBullets.空中祸害Bullet(0, 4, 9, 0.7f, 2) {{
                            splashDamage = 220;//范围伤害
                            splashDamageRadius = 8 * 8;//范围伤害的范围
                        }},
                        冷冻弹, new FantasyProjectBullets.空中祸害Bullet(70, 4, 9, 0.5f, 1) {{
                            status = 冷冻;
                            statusDuration = 15;
                        }},
                        金, new FantasyProjectBullets.空中祸害Bullet(120, 6, 9, 2f, 6),
                        铁板, new FantasyProjectBullets.空中祸害Bullet(360, 8, 9, 1f, 3),
                        钛合金, new FantasyProjectBullets.空中祸害Bullet(560, 8, 9, 1f, 3),
                        液电池, new FantasyProjectBullets.空中祸害Bullet(130, 6, 9, 1f, 3) {{
                            status = StatusEffects.shocked;
                            statusDuration = 60;
                        }},
                        水瓶, new FantasyProjectBullets.空中祸害Bullet(30, 4, 9, 1f, 0) {{
                            status = StatusEffects.wet;
                            statusDuration = 60;
                        }},
                        钻石, new FantasyProjectBullets.空中祸害Bullet(620, 6, 9, 1.4f, 3) {{
                            status = StatusEffects.slow;
                            statusDuration = 20;
                        }},
                        镍板, new FantasyProjectBullets.空中祸害Bullet(890, 10, 9, 1.7f, 3) {{
                            status = new StatusEffect("jianxue1") {{
                                healthMultiplier = 0.6f;//血量倍率
                                localizedName="血量倍率60%";
                            }};
                            statusDuration = 50;
                        }},
                        硬直弹, new FantasyProjectBullets.空中祸害Bullet(1300, 12, 9, 1.2f, 5) {{
                            status = StatusEffects.slow;
                            statusDuration = 80;
                        }},
                        啸动合金, new FantasyProjectBullets.空中祸害Bullet(2200, 20, 9, 1.5f, 6) {{
                            status = new StatusEffect("jianxue2") {{
                                healthMultiplier = 0.4f;//血量倍率
                                speedMultiplier = 0.5f;//移速
                                localizedName="血量倍率40%，移速50%";
                            }};
                            statusDuration = 50;
                        }}
                );
            }
        };
        魂灭 = new LaserTurret("魂灭") {{
            requirements(Category.turret, with(
                    Items.copper, 1200,
                    Items.lead, 350,
                    Items.graphite,
                    300, Items.surgeAlloy, 325,
                    Items.silicon, 325,
                    铁板, 50,
                    金, 200

            ));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 40f;
            recoil = 4f;
            size = 5;
            shake = 2f;
            range = 195 * 2f;
            reload = 90f;
            firingMoveFract = 0.5f;
            shootDuration = 320f;
            shootSound = Sounds.shootMeltdown;
            loopSound = Sounds.beamMeltdown;
            loopSoundVolume = 2f;
            rotateSpeed = 3f;
            shootType = new ContinuousLaserBulletType(1300 / 12f) {{
                length = 400f;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                status = StatusEffects.melting;
                drawSize = 420f;
                // timescaleDamage = true;
                incendChance = 0.4f;
                incendSpread = 5f;
                incendAmount = 1;
                ammoMultiplier = 1f;
            }};
            scaledHealth = 200;
            coolant = consumeCoolant(0.5f);
            consumePower(17f);
        }};
        魄散 = new PowerTurret("魄散") {{
            requirements(Category.turret, with(
                    Items.copper, 1200,
                    Items.lead, 350,
                    Items.graphite,
                    300, Items.surgeAlloy, 325,
                    Items.silicon, 325,
                    铁板, 50,
                    金, 200
            ));
            range = 195 * 2+40f;
            recoil = 2f;
            shake = 2f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            size = 5;
            scaledHealth = 280;
            targetAir = false;
            moveWhileCharging = false;
            accurateDelay = false;
            shootSound = loadSound("魄散充能");
            chargeSound = loadSound("魄散发射");
            reload = 240;//射速
            shoot.firstShotDelay = 300;//第一次射击延迟
            shoot = new ShootPattern() {
                {
                    shots = 4;
                    // firstShotDelay=0;
                    shotDelay = 15;
                }
            };
            shootType = new LaserBulletType(350) {{
                // Color[] colors = {Color.valueOf("ec745855"), Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                colors = new Color[]{Color.valueOf("ec7458"), Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                buildingDamageMultiplier = 0.04f;
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                status = StatusEffects.unmoving;//禁止
                statusDuration = 35;
                lifetime = 16f;
                drawSize = 400f;
                collidesAir = false;
                length = 173 * 2.5f;
                width = 60f;
                ammoMultiplier = 1f;
                // pierceCap = 4;
            }};
            scaledHealth = 200;
            coolantMultiplier = 0.8f; //液体冷却倍率
            coolant = consumeCoolant(0.5f);//液体消耗量
            consumePower(25f);
        }};
        排山 = new GuDingTurret("排山") {{
            reload = 80f;
            range = 80 * 8;
            shootCone = 45f;
            ammoUseEffect = Fx.casing1;
            health = 400;
            inaccuracy = 0f;
            size = 5;
            初始额外角度 = 90;
            configurable = true;
            rotateSpeed = 2f;
            targetAir = true; //空
            targetGround = true; //地
            shootSound = Vars.tree.loadSound("DONG");
            requirements(Category.turret, with(Items.copper, 450, graphite, 320, 钻石, 50, 镍板, 120, 铁, 300, 钛合金, 80));
            ammo(
                    硬直弹, new CT3PaiBulletType() {{
                        speed = 20;
                        lifetime = 50f;
                        damage = 350;
                        absorbable = false;
                        sprite = "ct_fantasy_project-zidan6";
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("76e9ff");
                        shrinkY = 0;
                        子弹宽度 = width = 300;
                        height = 30f;
                        collidesAir =
                                collidesGround = true;
                        hitEffect = shootEffect = smokeEffect = Fx.none;
                        pierce = true;//穿透
                        pierceBuilding = true;
                        lifetime = 50f;
                        buildingDamageMultiplier = 0.5f;
                        hitSound = Vars.tree.loadSound("ding");
                        hitSize = 300f;
                    }}

            );

        }};
        终焉 = new LaserTurret("终焉") {
            {
                //  buildType=LaserTurretBuilds::new;
                shootEffect = Fx.shootBigSmoke2;
                shootCone = 40f;
                recoil = 4f;
                size = 16;
                shake = 2f;
                reload = 90f;
                range = 150 * 8;
                firingMoveFract = 0.5f;
                shootDuration = 15 * 60;//发射持续时间
                //shoot.firstShotDelay = 200;//蓄力射击延迟
                shootSound = Sounds.shootMeltdown;
                loopSound = Sounds.beamMeltdown;
                loopSoundVolume = 2f;
                // envEnabled |= Env.space;
                rotateSpeed = 0.3f;//转速
                health = 28000;
                shootY = -1;
                shootType = new CT3LaserBulletType(72000 / 12f) {{
                    // shootY=-1;
                    length = 150 * 8;
                    hitEffect = Fx.hitMeltdown;
                    hitColor = Pal.meltdownHit;
                    status = StatusEffects.melting;
                    width = 30;//宽
                    frontLength = 100;
                    incendChance = 0.4f;
                    incendSpread = 5f;
                    incendAmount = 1;
                    ammoMultiplier = 1f;
                    // fadeTime = 180;//淡入淡出时间
                    // colors = new Color[]{Color.valueOf("ec745855"), Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                    //   lifetime = 15 * 60;

                }};
                scaledHealth = 200;
                coolant = consumeCoolant(0.5f);
                liquidCapacity = 120;
                coolantMultiplier = 0.05f; //液体冷却倍率
                consumePower(2000f);//12万电
                consumeLiquid(啸冷剂, 24 / 60f).update(true);
                unitSort = UnitSorts.farthest;//最远//攻击单位时的优先选择/closest/farthest/strongest/weakest
                drawer = new FantasyProjectTurretDrawer2() {
                    {
                        parts.addAll(
                                new RegionPart("-5") {{
                                    progress = PartProgress.warmup;
                                    mirror = false;//镜像
                                    blending = Blending.additive;
                                    // under = true;//在主体下面
                                    moveRot = 0;//倾斜角度
                                    moveY = -0;//上下
                                    moveX = 0f;//左右
                                    y=-12;
                                    outline=false;
                                    layer=115;
                                    colorTo= Color.valueOf("a2fefaff");//结束
                                   color= Color.valueOf("a2fefa00");//开始
                                   // shootWarmupSpeed=0.0065f;
                                   // minWarmup=0.0100f;

                                }},

                                new RegionPart("-散热3") {{
                                    progress = PartProgress.warmup;
                                    mirror = true;//镜像
                                    layerOffset = 0.009f;//图层偏移
                                    // under = true;//在主体下面
                                    moveRot = 0;//倾斜角度
                                    moveY = -3;//上下
                                    moveX = 3f;//左右
                                }},
                                new RegionPart("-散热2") {{
                                    progress = PartProgress.warmup;
                                    mirror = true;//镜像
                                    layerOffset = 0.008f;//图层偏移
                                    // under = true;//在主体下面
                                    moveRot = 0;//倾斜角度
                                    moveY = -6;//上下
                                    moveX = 6f;//左右
                                    //  moves.add(new PartMove(PartProgress.recoil, 0.5f, -0.5f, -8f));
                                }},
                                new RegionPart("-散热1") {{
                                    progress = PartProgress.warmup;
                                    mirror = true;//镜像
                                    layerOffset = 0.007f;//图层偏移
                                    //  under = true;//在主体下面
                                    moveRot = 0;//倾斜角度
                                    moveY = -9;//上下
                                    moveX = 9f;//左右
                                    // moves.add(new PartMove(PartProgress.recoil, 0.5f, -0.5f, -8f));
                                }},
                                new RegionPart("-仓板") {{
                                    progress = PartProgress.warmup;
                                    mirror = true;//镜像
                                    layerOffset = 0.007f;//图层偏移
                                    //  under = true;//在主体下面
                                    moveRot = 0;//倾斜角度
                                    moveY = 1;//上下
                                    moveX = 9f;//左右
                                    // moves.add(new PartMove(PartProgress.recoil, 0.5f, -0.5f, -8f));
                                }},

                                new RegionPart("-主体") {{
                                    progress = PartProgress.warmup;
                                    // moveY = 120;//上下
                                    layerOffset = 0.10f;//图层偏移

                                }},
                                new RegionPart("-伸缩1") {{
                                    progress = PartProgress.warmup;
                                    moveY = 30;//上下
                                    layerOffset = 0.09f;//图层偏移

                                }},
                                new RegionPart("-伸缩2") {{
                                    progress = PartProgress.warmup;
                                    moveY = 60;//上下
                                    layerOffset = 0.08f;//图层偏移

                                }},
                                new RegionPart("-伸缩3") {{
                                    progress = PartProgress.warmup;
                                    moveY = 110;//上下
                                    layerOffset = 0.07f;//图层偏移

                                }}

                        );


                    }
                };
                requirements(Category.turret, with(
                        copper, 12000,
                        lead, 15000,
                        液电池, 5000,
                        镍板, 2100,
                        钴, 3400,
                        石英, 6500,
                        钻石, 2800,
                        相织硅, 2300,
                        啸动合金, 800

                ));
                buildType = Build::new;
            }
            class Build extends LaserTurretBuild {
                public void draw() {
                    super.draw();
                    Draw.z(100);
                    Draw.rect(Core.atlas.find("ct_fantasy_project-终焉-1"), this.x+Angles.trnsx(this.rotation, -13, 0), this.y +Angles.trnsx(this.rotation, 0, 13));
                    Draw.rect(Core.atlas.find("ct_fantasy_project-终焉-2"), this.x+Angles.trnsx(this.rotation, -13, 0), this.y +Angles.trnsx(this.rotation, 0, 13), 90 + Time.time * 2);
                    Draw.rect(Core.atlas.find("ct_fantasy_project-终焉-3"), this.x+Angles.trnsx(this.rotation, -13, 0), this.y +Angles.trnsx(this.rotation, 0, 13), 90 - Time.time * 2);
                    Draw.rect(Core.atlas.find("ct_fantasy_project-终焉-4"), this.x+Angles.trnsx(this.rotation, -13, 0), this.y +Angles.trnsx(this.rotation, 0, 13), 90 + Time.time * 2);
                    //Draw.rect(Core.atlas.find("ct_fantasy_project-终焉-5"), this.x, this.y - 12);
                }
            }
        };
        尘埃 = new ItemTurret("尘埃") {
            {
                requirements(Category.turret, with(
                        copper, 12000,
                        lead, 15000,
                        液电池, 600,
                        镍板, 280,
                        钴, 1300,
                        石英, 750,
                        钻石, 300,
                        相织硅, 230,
                        啸动合金, 800,
                        黎辉水晶, 100

                ));
                unitSort = UnitSorts.strongest;//最强//攻击单位时的优先选择/closest/farthest/strongest/weakest
                targetGround = targetAir = true; //空地
                inaccuracy = 13;//精度
                ammoPerShot = 10;//每发消耗的资源
                recoil = 8;//后座力动画
                reload = 30 * 60;//射速

                size = 12;
                health = 45000;
                range = 150 * 8;
                maxAmmo = 100;
                //heatColor= 66B1FFFF;
                update = true;
                hasPower = true;
                shootSound = shootCorvus;
                chargeSound = none;
                moveWhileCharging = true;
                shoot.firstShotDelay = 200;//蓄力射击延迟
                shake = 4;
                rotateSpeed = 0.4f;
                liquidCapacity = 60;
                coolantMultiplier = 0f; //液体冷却倍率
                consumeLiquid(啸冷剂, 10 / 60f);
                consumePower(3000f);//18万电
                ammo(
                        啸动合金, new FantasyProjectBullets.尘埃Bullet()
                );

            }

        };

    }
};
