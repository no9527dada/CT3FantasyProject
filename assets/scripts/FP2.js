Blocks.salvo.ammoTypes.put(
    Items.titanium,(() => {
        const D = new JavaAdapter(BasicBulletType, {});
        D.damage = 22;
        D.speed = 3.8
        D.width = 9;
        D.height = 12;
        D.shootEffect = Fx.shootBig;
        D.smokeEffect = Fx.shootBigSmoke;
        D.ammoMultiplier = 2;
        D.lifetime = 55;
        return D;
    })(),
);
Blocks.cyclone.ammoTypes.put(
    Items.plastanium, (() => {
        const D = new JavaAdapter(FlakBulletType, {});
        D.damage = 8;
        D.speed = 4
        D.ammoMultiplier = 4;
        D.splashDamageRadius = 40;
        D.splashDamage = 37.5;
        D.fragBullets = 6;
        D.hitEffect = Fx.plasticExplosion;
        D.frontColor = Pal.plastaniumFront;
        D.backColor = Pal.plastaniumBack;
        D.shootEffect = Fx.shootBig;
          D.knockback =1.5;
        D.collidesGround = true;
        D.explodeRange = 20;
        D.fragBullet = (() => {
            const A = new JavaAdapter(BasicBulletType, {});
           A.damage = 12;
           A.speed = 2.5
            A.width = 10;
            A.knockback =0.5;
            A.height = 12;
            A.shrinkY = 1;
            A.lifetime = 15;
            A.backColor = Pal.plastaniumBack;
            A.frontColor = Pal.plastaniumFront;
            A.despawnEffect = Fx.none;
            return A;
        })();
        return D;
    })());