package FantasyProject.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.struct.ObjectMap;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.world.blocks.defense.turrets.Turret;
import mindustry.world.draw.DrawTurret;

public class FantasyProjectTurretDrawer extends DrawTurret {
    //圆球位置
    public float cx = -20f, cy=0;
    //圆球半径
    public float radius = 10f;
    public float  range = 60;
    //闪电链半径
    public float lightingRadius = 16f;
    //闪电链间隔
    public float lightingTime = 15f;
    //闪电链数量
    public int lightingAmount = 5;
    //颜色
    public Color color = Pal.heal;

    public ObjectMap<Building, Float> timers = new ObjectMap<>();

    public Vec2 vec2A = new Vec2();

    public FantasyProjectTurretDrawer(String basePrefix) {
        super(basePrefix);
    }

    public FantasyProjectTurretDrawer() {
        super();
    }



    public float blinkScl = 20f, blinkSize = 0.1f;
    public float effectRadius = 5f, sectorRad = 0.14f, rotateSpeed = 0.5f;
    public int sectors = 5;
    protected float curStroke;


    @Override
    public void draw(Building build) {
        super.draw(build);
        Turret.TurretBuild tb = (Turret.TurretBuild) build;

        Draw.z(Layer.effect);
        Draw.color(color);
        float x2 = build.x + tb.recoilOffset.x + vec2A.x;
        float y2 = build.y + tb.recoilOffset.y + vec2A.y;
        vec2A.trns(tb.rotation, cx, cy);
/*
        float x2 = build.x + tb.recoilOffset.x + vec2A.x;
        float y2 = build.y + tb.recoilOffset.y + vec2A.y;
        Fill.circle(x2, y2, radius);*/
        Tmp.v1.trns(build.rotation - 90, cx, cy).add(build.x, build.y);
        float rx = Tmp.v1.x, ry = Tmp.v1.y;
        float orbRadius = effectRadius * (1f + Mathf.absin(blinkScl, blinkSize));

        Fill.circle(x2, y2, orbRadius);
        Draw.color();
        Fill.circle(x2, y2, orbRadius / 2f);

        Lines.stroke((0.7f + Mathf.absin(blinkScl, 0.7f)), color);

        for(int i = 0; i < sectors; i++){
            float rot = build.rotation + i * 360f/sectors - Time.time * rotateSpeed;
            Lines.arc(x2, y2, orbRadius + 3f, sectorRad, rot);
        }

        Lines.stroke(Lines.getStroke() * curStroke);

        if(curStroke > 0){
            for(int i = 0; i < sectors; i++){
                float rot = build.rotation + i * 360f/sectors + Time.time * rotateSpeed;
                Lines.arc(x2, y2, range, sectorRad, rot);
            }
        }

        Drawf.light(x2, y2, range * 1.5f, color, curStroke * 0.8f);


        if (timers.containsKey(build)){
            float timer = timers.get(build);
            timer += Vars.state.isPaused() ? 0 : Time.delta;
            if(timer > lightingTime){
                for (int i = 0; i < lightingAmount; i++) Fx.chainLightning.at(x2, y2, 0, color, new Vec2().trns(Mathf.random(360), lightingRadius).add(x2,y2));
                timer -= lightingTime;
            }
            timers.put(build, timer);
        }else timers.put(build, 0f);

        Draw.color();
        Draw.reset();
    }
}
