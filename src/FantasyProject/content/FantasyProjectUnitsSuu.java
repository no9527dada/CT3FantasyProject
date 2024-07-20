package FantasyProject.content;

import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.abilities.StatusFieldAbility;
import mindustry.gen.Sounds;
import mindustry.type.StatusEffect;
import mindustry.type.UnitType;

import static FantasyProject.content.FantasyProjectUnitsBulletTypes.*;
import static CtCoreSystem.CoreSystem.CT3Sound.loadSound;
import static CtCoreSystem.CoreSystem.type.CTColor.C;

public class FantasyProjectUnitsSuu {
    static UnitType 天穹,飞鹰,  秃鹫, 战鹰, 天泽;


    public static void load() {
        StatusEffect 射速 = new StatusEffect("暴走") {{
            reloadMultiplier = 2.2f;
        }};


        天穹 = new 战机("天穹", 3.7f, 2, 800) {{

            weapons.add(new 武器2(0, 0, 10));
            //副武器
            weapons.add(new 武器僚机4(-20, 0, 30, 15) {{
                Y移动倍率 = 0;
                name = "ct_fantasy_project-天穹僚机";
                X移动倍率 = -40; 移动半径 = 1;
            }});
            weapons.add(new 武器僚机4(20, 0, 30, -15) {{
                Y移动倍率 = 0;
                name = "ct_fantasy_project-天穹僚机";
                X移动倍率 = 40; 移动半径 = 1;
            }});
            abilities.add(new RepairFieldAbility(800f, 60f * 4, 0.5f));

        }};

        秃鹫 = new 战机("秃鹫", 4f, 3, 1000) {{
            abilities.add(new RepairFieldAbility(1000f, 60f * 3, 0.5f));
            abilities.add(new StatusFieldAbility(射速, 60f * 5, 60f * 15f, 1f));
            weapons.add(new 武器3(0){{shootSound=Sounds.shootBig;}});
            weapons.add(new 武器3(3));
            weapons.add(new 武器3(-3));
            weapons.add(new 武器3(6));
            weapons.add(new 武器3(-6));
            weapons.add(new 武器3(9));
            weapons.add(new 武器3(-9));
            weapons.add(new 武器3(12));
            weapons.add(new 武器3(-12));
            weapons.add(new 武器3(15));
            weapons.add(new 武器3(-15));
            weapons.add(new 武器3(18));
            weapons.add(new 武器3(-18));
            weapons.add(new 武器3(21));
            weapons.add(new 武器3(-21));
            weapons.add(new 武器3(24));
            weapons.add(new 武器3(-24));
            weapons.add(new 武器3(27));
            weapons.add(new 武器3(-27));
            weapons.add(new 武器3(30));
            weapons.add(new 武器3(-30));
            weapons.add(new 武器3(33));
            weapons.add(new 武器3(-33));
            weapons.add(new 武器3(36));
            weapons.add(new 武器3(-36));
            weapons.add(new 武器3(39));
            weapons.add(new 武器3(-39));
            weapons.add(new 武器3(42));
            weapons.add(new 武器3(-42));
            weapons.add(new 武器3(45));
            weapons.add(new 武器3(-45));

            //副武器  写好了
            weapons.add(new 副武器僚机1(15, 0, 100) {{
                Y移动倍率 = 1;
                name = "ct_fantasy_project-秃鹫僚机";
                X移动倍率 = 1;
                X初相=90;
                移动半径 = 40;
            }});
            weapons.add(new 副武器僚机1(-15, 0, 100) {{
                Y移动倍率 = 1;
                name = "ct_fantasy_project-秃鹫僚机";
                X移动倍率 = -1;
                X初相=90;
                移动半径 = 40;
            }});

            weapons.add(new 副武器僚机1(15, 0, 100) {{
                Y移动倍率 = -1;
                name = "ct_fantasy_project-秃鹫僚机";
                X移动倍率 = -1;
                X初相=-90;
                移动半径 = 40;
            }});
            weapons.add(new 副武器僚机1(-15, 0, 100) {{
                Y移动倍率 = -1;
                name = "ct_fantasy_project-秃鹫僚机";
                X移动倍率 = 1;
                X初相=-90;
                移动半径 = 40;
            }});

        }};
        飞鹰 = new 战机("飞鹰", 5.6f, 4, 1300) {{
            abilities.add(new RepairFieldAbility(500f, 60f * 2, 0.5f));
            weapons.add(new 武器1(
                    "ct_fantasy_project-zidan1", 8, 0, 0, 25, 90,
                    15, 40, 12, 30, C("feb203"), C("feec03"), Sounds.missile
            ));
            weapons.add(new 武器1(
                    "ct_fantasy_project-zidan2", 8, 0, 15, 10, 70,
                    15, 40, 8, 30, C("feb203"), C("feec03"), Sounds.none
            ));
            weapons.add(new 武器1(
                    "ct_fantasy_project-zidan2", 8, 0, -15, 10, 70,
                    15, 40, 8, 30, C("feb203"), C("feec03"), Sounds.none
            ));
            weapons.add(new 武器1(
                    "ct_fantasy_project-zidan2", 5, 0, 30, -5, 50,
                    15, 40, 6, 18, C("feb203"), C("feec03"), Sounds.none
            ));
            weapons.add(new 武器1(
                    "ct_fantasy_project-zidan2", 5, 0, -30, -5, 50,
                    15, 40, 6, 18, C("feb203"), C("feec03"), Sounds.none
            ));

            //副武器  写好了
            weapons.add(new 武器僚机5(
                    "ct_fantasy_project-zidan4", 30, 0, 0, 0, 180,
                    15, 50, 40, 40, C("feb203"), C("feec03"),
                    195, -15, 150
            ) {{
                shootSound = loadSound("wu");
                Y移动倍率 = 1;
                name = "ct_fantasy_project-飞鹰僚机";
                X移动倍率 = 1;
                移动半径 = 40;
            }});
            weapons.add(new 武器僚机5(
                    "ct_fantasy_project-zidan4", 30, 0, 0, 0, 180,
                    15, 50, 40, 40, C("feb203"), C("feec03"),
                    195, 15, 150
            ) {{
                shootSound = Sounds.dullExplosion;
                Y移动倍率 = 1;
                name = "ct_fantasy_project-飞鹰僚机";
                X移动倍率 = -1;
                移动半径 = 40;
            }});
        }};
        战鹰 = new 战机("战鹰", 7f, 5, 1600) {{
            abilities.add(new RepairFieldAbility(800f, 60f * 3, 0.5f));
            abilities.add(new StatusFieldAbility(射速, 60f * 10, 60f * 30f, 1f));

            // 副武器
            weapons.add(new 副武器僚机2(10, 0, 0, 120, 8, 0, 90, 0, 0, "ct_fantasy_project-zidan5") {{
                shootSound = Sounds.lasershoot;
                Y移动倍率 = 1;
                name = "ct_fantasy_project-战鹰僚机";
                //X初相=-120;
                X移动倍率 = 1;
                移动半径 = 40;
            }});
            // 副武器
            weapons.add(new 副武器僚机2(10, 0, 0, 120, 8, 0, -90, 0, 0, "ct_fantasy_project-zidan5") {{
                shootSound = Sounds.none;
                Y移动倍率 = 1;
                name = "ct_fantasy_project-战鹰僚机";
                X移动倍率 = -1;
                移动半径 = 40;
            }});

            weapons.add(new 武器4(-40, 0, 10, 20, 0, 15, -6, 20, "ct_fantasy_project-yueL") {{
                shootSound = loadSound("战鹰M2");
            }});
            weapons.add(new 武器4(40, 0, 10, 20, 0, -15, 6, -20, "ct_fantasy_project-yueR"));

            weapons.add(new 武器4(-40, 0, 19, 20, 0, 30, -5, 20, "ct_fantasy_project-yueL"));
            weapons.add(new 武器4(40, 0, 19, 20, 0, -30, 5, -20, "ct_fantasy_project-yueR"));

            weapons.add(new 武器4(-40, 0, 33, 20, 0, 45, -4, 22, "ct_fantasy_project-yueL"));
            weapons.add(new 武器4(40, 0, 33, 20, 0, -45, 4, -22, "ct_fantasy_project-yueR"));


            weapons.add(new 武器4(-40, 0, 40, 20, 0, 60, -4, 25, "ct_fantasy_project-yueL"));
            weapons.add(new 武器4(40, 0, 40, 20, 0, -60, 4, -25, "ct_fantasy_project-yueR"));

        }};
        天泽 = new 战机("天泽", 10f, 6, 2500) {{
            abilities.add(new RepairFieldAbility(1200, 60f * 2, 0.5f));
            abilities.add(new StatusFieldAbility(射速, 60f * 5, 60f * 15f, 1f));

            //副武器
            weapons.add(new 副武器僚机3(30, 0, 2200){{
                Y移动倍率 = 0;
                name = "ct_fantasy_project-天泽僚机";
                X移动倍率 = 1;
                移动半径 = -40;
                移动速度倍率=4;

            }});

            weapons.add(new 副武器僚机3(-30, 0, 2200){{
                Y移动倍率 = 0;
                name = "ct_fantasy_project-天泽僚机";
                X移动倍率 = 1;
                移动速度倍率=4;
                移动半径 = 40;
            }});

            //主武
            weapons.add(new 武器2(0, 0, 100, 1250) {{
                shootSound = loadSound("天泽1");
            }});

            weapons.add(new 武器2(0, 15, 0, 600));
            weapons.add(new 武器2(0, -15, 0, 600));
/*             weapons.add(new 武器2(90,-90,0,0,5,40,400));
            weapons.add(new 武器2(-90,90,0,0,5,40,400));*/

            weapons.add(new 武器2(0, 15, 200, 600));
            weapons.add(new 武器2(0, -15, 200, 600));
 /*           weapons.add(new 武器2(90,-90,0,200,5,40,400));
           weapons.add(new 武器2(-90,90,0,200,5,40,400));*/


            weapons.add(new 武器2(0, 30, -40, 500));
            weapons.add(new 武器2(0, -30, -40, 500));


            weapons.add(new 武器2(0, 45, -70, 400));
            weapons.add(new 武器2(0, -45, -70, 400));

            weapons.add(new 武器2(0, 60, -80, 800) {{
                rotate = true;
                shootCone = 30;
            }});
            weapons.add(new 武器2(0, -60, -80, 800) {{
                rotate = true;
                shootCone = 30;
            }});
       /*     weapons.add(new Weapon("elude-weapon"){{
                shootSound = Sounds.blaster;
                y = -2f;
                x = 4f;
                top = true;
                mirror = true;
                reload = 45f;
                baseRotation = -25f;
                shootCone = 100f;

                shoot = new ShootSpread(3, 11f);

                bullet = new BasicBulletType(5f, 16){{
                    width = 7f;
                    height = 12f;
                    lifetime = 230f;
                    shootEffect = Fx.sparkShoot;
                    smokeEffect = Fx.shootBigSmoke;
                    hitColor = backColor = trailColor = Pal.suppress;
                    frontColor = Color.white;
                    trailWidth = 1.5f;
                    trailLength = 5;
                    hitEffect = despawnEffect = Fx.hitBulletColor;

                    homingRange = 50*8f;
                    homingPower = 0.9f;
                    homingDelay = 60f;
                }};
            }});*/
        }};
    }
}
