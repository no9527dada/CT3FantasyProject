package FantasyProject.content;

import arc.audio.Sound;
import arc.graphics.Color;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.content.UnitTypes;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootPattern;
import mindustry.entities.pattern.ShootSpread;
import mindustry.entities.units.WeaponMount;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

import static CtCoreSystem.CoreSystem.CT3Sound.loadSound;
import static CtCoreSystem.CoreSystem.type.CTColor.C;

public class FantasyProjectUnitsBulletTypes {
    public static class 战机 extends UnitType {
        public 战机(String name, float 移速, float 建造速, float 血量) {
            super(name);
            aiController = BuilderAI::new;
            isEnemy = false;
            constructor = UnitTypes.gamma.constructor;
            lowAltitude = true;
            flying = true;
            mineSpeed = 8f;
            mineTier = 2;
            buildSpeed = 建造速;
            drag = 0.05f;
            speed = 移速;
            rotateSpeed = 19f;
            accel = 0.11f;
            fogRadius = 0f;
            itemCapacity = 70;
            health = 血量;
            engineOffset = 6f;
            hitSize = 11f;

        }
    }

    public static class 武器1 extends Weapon {
        @Override
        protected float bulletRotation(Unit unit, WeaponMount mount, float bulletX, float bulletY) {
            return unit.rotation + mount.rotation;
        }

        public 武器1(
                String 贴图, float 射速, float 武器角度, float X横, float Y竖,
                float 伤害, float 子弹速度, float 子弹存在时间,
                float 子弹宽, float 子弹长, Color backC, Color frontC, Sound 声音
        ) {
            {
                display = true;//武器在ui面板里显示
                rotate = mirror = top = false;
                reload = 射速;
                x = X横;
                y = Y竖;
                baseRotation = 武器角度;
                shootCone = 90f;
                shootSound = 声音;
                bullet = new BasicBulletType() {{
                    speed = 子弹速度;
                    damage = 伤害;
                    width = 子弹宽;
                    height = 子弹长;
                    lifetime = 子弹存在时间;
                    sprite = 贴图;
                    shrinkY = 0;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0f;
                    backColor = backC;
                    frontColor = frontC;
                    //  homingPower = 0.04f;
                }};
            }
        }

        public 武器1(
                String 贴图, float 射速, float 武器角度, float X横, float Y竖,
                float 伤害, float 子弹速度, float 子弹存在时间,
                float 子弹宽, float 子弹长, Color backC, Color frontC
                , float WS, float WM
        ) {
            {
                rotate = mirror = top = false;
                reload = 射速;
                x = X横;
                y = Y竖;
                baseRotation = 武器角度;
                shootCone = 90f;
                shootSound = loadSound("wu");
                bullet = new BasicBulletType() {{
                    speed = 子弹速度;
                    damage = 伤害;
                    width = 子弹宽;
                    height = 子弹长;
                    lifetime = 子弹存在时间;
                    sprite = 贴图;
                    shrinkY = 0;
                    pierce = true;//穿透
                    shootEffect =Fx.none;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0f;
                    backColor = backC;
                    frontColor = frontC;
                    weaveScale = WS;
                    weaveMag = WM;
                    weaveRandom = false;

                }};
            }
        }


        //副武器

    }

    public static class 武器2 extends Weapon {
        @Override
        protected float bulletRotation(Unit unit, WeaponMount mount, float bulletX, float bulletY) {
            return unit.rotation;
        }

        public 武器2(int 角度, int 角度2, int X横, int Y竖, int time1, int time2, int De) {
            {
                shootSound = loadSound("wu");
                mirror = top = false;
                reload = 45f;
                x = X横;
                y = Y竖;
                baseRotation = 角度;
                shootCone = 360f;
                bullet = new BasicBulletType(8f, De) {{
                    sprite = "ct_fantasy_project-shu0";
                    backColor = Color.valueOf("4d76ff");
                    frontColor = Color.valueOf("93faff");
                    shrinkY = 0;
                    width = 180f;
                    height = 10f;
                    pierce = true;//穿透
                    lifetime = time1;
                    hitEffect = shootEffect = smokeEffect = Fx.none;
                    buildingDamageMultiplier = 0f;
                    fragBullets = 1;
                    fragOnHit = false;
                    fragVelocityMin = fragVelocityMax = 1f;
                    fragRandomSpread = 0;//破片散布分裂角度范围??
                    fragSpread = 0;
                    fragAngle = 角度2;//破片散布分裂角度
                    fragBullet = new BasicBulletType(20f, De) {{
                        sprite = "ct_fantasy_project-shu";
                        backColor = Color.valueOf("4d76ff");
                        frontColor = Color.valueOf("93faff");
                        shrinkY = 0;
                        pierce = true;//穿透
                        width = 10f;
                        height = 180f;
                        lifetime = time2;
                        shootEffect = Fx.none;
                        smokeEffect = Fx.none;
                        buildingDamageMultiplier = 0f;
                    }};
                }};
            }
        }

        public 武器2(int 角度, int X, int Y, int De) {
            {
                //this.name = name;
                shootSound = loadSound("wu");
                mirror = top = false;
                reload = 45f;
                x = X;
                y = Y;
                baseRotation = 角度;
                shootCone = 360f;
            /*    shoot = new ShootSpread() {{
                    shots = 15;
                    shotDelay = 3f;
                    spread = 3f;
                }};*/
                //ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(20f, De) {{
                    absorbable = false;//子弹不被护盾仪吸收
                    sprite = "ct_fantasy_project-shu";
                    backColor = Pal.heal;//Color.valueOf("4d76ff");
                    frontColor = Color.valueOf("93faff");
                    shrinkY = 0;
                    width = 10f;
                    hitEffect = shootEffect = smokeEffect = Fx.none;
                    pierce = true;//穿透
                    height = 180F;
                    lifetime = 50f;
                    buildingDamageMultiplier = 0f;
                }};

            }

        }
        public 武器2(int X, int Y, int 伤害) {
            mirror = top = false;
            reload = 5f;
            x = X;
            y = Y;
            //baseRotation = 15f;
            shootCone = 30f;
            shoot = new ShootAlternate() {{
                spread = 8;//间隔距离
                shots = 3;//子弹数
                barrels = 3;//枪管数量
            }};
            ejectEffect = Fx.casing1;
            bullet = new BasicBulletType(8f, 伤害) {{
                shrinkY = 0;
                width = 6.5f;
                height = 11f;
                lifetime = 60f;
                shootEffect = Fx.none;
                smokeEffect = Fx.shootSmallSmoke;
                buildingDamageMultiplier = 0f;
                backColor =Color.valueOf("c9fa85");
                frontColor = Color.valueOf("85faee");
                lightning = 3;//闪电根数
                lightningLength = 5;//闪电长度
                lightningColor = Color.valueOf("faf885");//闪电颜色
                lightningDamage = 3;//闪电伤害
            }};

        }

       /* public 武器天泽3(int 枪管角度 ,int 枪管距离 ,int 分裂角度,int Y,int De,int time1,int time2,int X) {
            {
                //this.name = name;
                shootSound=loadSound("天泽1");
                mirror = top = false;
                reload = 45f;
                y = Y;
                x = X;

               // baseRotation = ;
                shootCone = 100f;
                shoot=new  ShootAlternate(){{
                    barrelOffset = 枪管角度;//枪管角度
                    spread = 枪管距离;//枪管相隔距离
                    barrels = 2;//枪管数量
                }};
                //ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(20f, De) {{
                    sprite="ct_fantasy_project-shu";
                    backColor =Color.valueOf("4d76ff");
                    frontColor = Color.valueOf("93faff");
                    shrinkY = 0;
                    width = 180f;
                    height = 10f;
                    pierce=true;//穿透
                    lifetime = time1;
                    hitEffect= shootEffect = smokeEffect = Fx.none;
                    buildingDamageMultiplier = 0.01f;
                    fragBullets =1;
                    fragOnHit = false;
                    fragVelocityMin =fragVelocityMax = 1f;
                    fragRandomSpread = 0;//破片散布分裂角度??
                    fragSpread=0;
                    fragAngle=分裂角度;
                    fragBullet = new BasicBulletType(20f, De) {{
                        sprite="ct_fantasy_project-shu0";
                        backColor =Color.valueOf("4d76ff");
                        frontColor = Color.valueOf("93faff");
                        shrinkY = 0;
                        pierce=true;//穿透
                        width = 10f;
                        height = 180f;
                        lifetime = time2;
                        shootEffect = Fx.none;
                        smokeEffect = Fx.none;
                        buildingDamageMultiplier = 0.01f;
                    }};
                }};
            }
        }*/
    }

    public static class 武器3 extends Weapon {

        public 武器3(int 角度) {
            {
                //this.name = name;
                mirror = top = false;
                reload = 15f;
                x = 1f;
                y = 2f;
                baseRotation = 角度;
                shootCone = 360f;
            /*    shoot = new ShootSpread() {{
                    shots = 15;
                    shotDelay = 3f;
                    spread = 3f;
                }};*/
                ejectEffect = Fx.casing1;
                shootSound=Sounds.none;
                bullet = new BasicBulletType(5f, 50) {{
                    shrinkY = 0;
                    width = 6.5f;
                    height = 11f;
                    lifetime = 70f;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0f;
                    lightning = 3;//闪电根数
                    lightningLength = 5;//闪电长度
                    lightningColor = Color.valueOf("4ae636");//闪电颜色
                    lightningDamage = 4;//闪电伤害
                    //  homingPower = 0.04f;
                }};
            }
        }



    }

    public static class 武器4 extends Weapon {
        @Override
        protected float bulletRotation(Unit unit, WeaponMount mount, float bulletX, float bulletY) {
            return unit.rotation + baseRotation;
        }

        public 武器4(int X, int Y, int 持续, int 速度, int 子弹旋转角度, int 角度, float WM, float WS, String 贴图) {
            {
                //this.name = name;
                rotate=mirror = top = false;
                reload = 15f;
                x = X;
                y = Y;
                baseRotation = 角度;
                shootCone = 360f;
            /*    shoot = new ShootSpread() {{
                    shots = 15;
                    shotDelay = 3f;
                    spread = 3f;
                }};*/
                ejectEffect = Fx.casing1;
                shootSound = Sounds.none;
                bullet = new BasicBulletType(速度, 700) {
                    {
                        absorbable = false;//子弹不被护盾仪吸收
                        sprite = 贴图;
                        backColor = Color.valueOf("d564de");
                        frontColor = Color.valueOf("f9abff");
                        shrinkY = 0;
                        width = 70f - 20;
                        height = 109f - 20;
                        lifetime = 持续;
                        spin = 子弹旋转角度;//子弹旋转
                        pierce = true;//穿透
                        despawnEffect = Fx.none;
                        shootEffect = Fx.none;
                        smokeEffect = Fx.shootSmallSmoke;
                        buildingDamageMultiplier = 0.0f;
                        weaveMag = WM;
                        weaveScale = WS;
                        weaveRandom = false;//随机方向
                        //  homingPower = 0.04f;
                    }
                };
            }
        }
    }
    // 武器 副武器僚机
    public static class 副武器僚机1 extends FantasyProjectSuu {
        public 副武器僚机1(int X, int Y, int 伤害) {
            {
                controllable = mirror = top = false;
                autoTarget = true;//被动开火
               // shake = 2f;//射击时屏幕震动
                shootY = Y;
                shootX = X;
                x = 0;
                reload = 55f;
                recoil = -1f;//武器射击时后退
                shootSound = Sounds.shockBlast;
                rotate = false;//武器旋转
                shootCone = 120f;
                // shoot = new ShootSpread(1,0);

                bullet = new LaserBulletType() {{
                    damage = 伤害;
                    impact=false;
                    recoil = 0f;//射击时单位后退
                    sideAngle = 45f;
                    sideWidth = 1f;
                    sideLength = 70f;
                    healPercent = 10f;
                    // collidesTeam = true;
                    laserEffect = Fx.none;
                    length = 240*1.5f ;
                    width = 32f;
                    // lengthFalloff = 5f;
                    colors = new Color[]{Color.valueOf("dafa85").cpy().a(0.4f), Color.valueOf("dafa85"), Color.white};
                }};

            }
        }
    }

    public static class 副武器僚机2 extends FantasyProjectSuu {
        @Override
        protected float bulletRotation(Unit unit, WeaponMount mount, float bulletX, float bulletY) {
            return unit.rotation + baseRotation;
        }

        public 副武器僚机2(int 子弹大小,int X, int Y, int 持续, int 速度, int 子弹旋转角度, int 角度, float WM, float WS, String 贴图) {
            {
                //this.name = name;
                controllable = mirror = top = false;
                reload = 120f;
                autoTarget = true;//被动开火
                x = X;
                y = Y;
                baseRotation = 角度;
                shootCone = 360f;
              shoot = new ShootSpread() {{
                    shots = 3;
                    //shotDelay = 7f;
                    spread = 60/6f;
                }};
                //shoot = new ShootSpread(6, 60 / 6f);
                ejectEffect = Fx.casing1;
                shootSound=loadSound("战鹰M1");
                bullet = new BasicBulletType(速度, 800) {
                    {
                        sprite = 贴图;
                        backColor = Color.valueOf("d564de");
                        frontColor = Color.valueOf("f9abff");
                        shrinkY = 0;
                        width = 20+子弹大小;
                        height =40+子弹大小;
                        lifetime = 持续;
                        spin = 子弹旋转角度;//子弹旋转
                        pierce = true;//穿透
                        despawnEffect = Fx.none;
                        shootEffect = Fx.none;
                        smokeEffect = Fx.shootSmallSmoke;
                        buildingDamageMultiplier = 0.0f;
                        weaveMag = WM;
                        weaveScale = WS;
                        weaveRandom = false;//随机方向
                        homingPower = 0.1f;
                        homingRange = 100f;
                        homingDelay = 20f;

                        trailColor =C("d564de");
                        trailParam = 4;
                        trailLength = 8;
                        trailWidth = 4;
                        trailInterval = 5;
                        trailRotation = true;
                        trailEffect = Fx.none;
                    }
                };
            }
        }
    }

    public static class 副武器僚机3 extends FantasyProjectSuu {
        public 副武器僚机3(int X, int Y, int 伤害) {
            {
                controllable = mirror = top = false;
                autoTarget = true;//被动开火
                shake = 1f;//射击时屏幕震动
                shootY = Y;
                shootX = X;
                x = 0;
                reload = 70f;
                shootCone = 90f;
                recoil = 0f;//射击时后退
/*                shoot = new ShootAlternate(){{
                    spread = 30;//间隔距离
                    shots = 2;//子弹数
                    barrels = 2;//枪管数量
                }};*/
                shoot.firstShotDelay = Fx.greenLaserChargeSmall.lifetime - 1f;
                parentizeEffects = true;//射击效果跟随单位
                rotate = false;//武器旋转
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                continuous = true;
                cooldownTime = 200f;
                bullet = new ContinuousLaserBulletType() {{
                    damage = 伤害/12F;
                    length = 180*4f;
                    hitEffect = Fx.hitMeltHeal;
                    drawSize = 420f;
                    lifetime = 180f;
                    shake = 1f;
                    despawnEffect = Fx.smokeCloud;
                    smokeEffect = Fx.none;

                    chargeEffect = Fx.greenLaserChargeSmall;

                    incendChance = 0.1f;
                    incendSpread = 5f;
                    incendAmount = 1;

                    //constant healing
                    healPercent = 1f;
                    collidesTeam = true;

                    colors = new Color[]{Pal.heal.cpy().a(.2f), Pal.heal.cpy().a(.5f), Pal.heal.cpy().mul(1.2f), Color.white};
                }};

                shootStatus = StatusEffects.slow;
                shootStatusDuration = 3 * 60f;

            }
        }
    }
    public static class 武器僚机4 extends FantasyProjectSuu {  //1级战机 天穹使用
        @Override
        protected float bulletRotation(Unit unit, WeaponMount mount, float bulletX, float bulletY) {
            return unit.rotation + mount.rotation;
        }
        public 武器僚机4(int X, int Y, int De, int 角度) {

            reload = 80f;
            x = X;
            y = Y;
            controllable = mirror = top = false;
            autoTarget = true;//被动开火
            rotate = false;//武器旋转;
            shake = 1f;
            inaccuracy = 0f;
            // velocityRnd = 0.2f;
            shootSound = Sounds.missile;
            baseRotation = 角度;
            shoot = new ShootPattern() {{
                shotDelay = 6;
                firstShotDelay = 50;
                shots = 4;
            }};
            shootCone = 30f;
            bullet = new MissileBulletType(4f, De, "missile") {{
                width = 13f;
                height = 20f;
             /*       shrinkY = 0f;
                    drag = -0.003f;*/

                splashDamageRadius = 5 * 8;
                splashDamage = De * 2;
                lifetime = 150f;
                trailColor = Pal.unitBack;
                backColor = Pal.unitBack;
                frontColor = Pal.unitFront;
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
              /*      weaveScale = 6f;
                    weaveMag = 1f;*/

                homingRange = 50 * 8f;
                homingPower = 0.1f;
                homingDelay = 60f;
            }};

        }
    }
    public static class 武器僚机5 extends FantasyProjectSuu {
        @Override
        protected float bulletRotation(Unit unit, WeaponMount mount, float bulletX, float bulletY) {
            return unit.rotation + mount.rotation;
        }
           public 武器僚机5(
            String 贴图, float 射速, float 武器角度, float X横, float Y竖,
        float 伤害, float 子弹速度, float 子弹存在时间,
        float 子弹宽, float 子弹长, Color backC, Color frontC,
        float WS, float WM, float time2

        ) {
        {
            controllable =rotate = mirror = top = false;
            autoTarget = true;//被动开火
            reload = 射速;
            x = X横;
            y = Y竖;
            baseRotation = 武器角度;
            shootCone = 120f;
            rotate = false;//武器旋转
            shootSound = loadSound("wu");
            bullet = new BasicBulletType() {{
                speed = 子弹速度;
                damage = 伤害;
                width = 子弹宽;
                height = 子弹长;
                lifetime = 子弹存在时间;
                sprite = 贴图;
                shrinkY = 0;
                pierce = true;//穿透
                shootEffect = Fx.none;
                smokeEffect = Fx.shootSmallSmoke;
                buildingDamageMultiplier = 0f;
                backColor = backC;
                frontColor = frontC;
                fragBullets = 1;
                fragOnHit = true;// 击中单位时是否分裂子弹
                fragVelocityMin = fragVelocityMax = 1f;
                fragRandomSpread = 0;//破片散布分裂角度??
                fragSpread = 0;
                fragAngle = 0;
                fragBullet = new BasicBulletType(20f, 伤害 / 1.5f) {{
                    sprite = "ct_fantasy_project-zidan4";
                    backColor = backC;
                    frontColor = frontC;
                    shrinkY = 0;
                    pierce = true;//穿透
                    width = 40f;
                    height = 40f;
                    lifetime = time2;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    buildingDamageMultiplier = 0f;
                    weaveScale = WS;
                    weaveMag = WM;
                    weaveRandom = false;
                }};
            }};
        }
    }
    }

}