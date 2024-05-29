//---------------------@滞人编写
const CreatorsStyles=new ImageButton.ImageButtonStyle();
CreatorsStyles.down = Styles.flatDown;
CreatorsStyles.up = Styles.black6;
CreatorsStyles.over = flatOver;
CreatorsStyles.disabled = Styles.black8;
CreatorsStyles.imageDisabledColor = Color.lightGray;
CreatorsStyles.imageUpColor = Color.white;

const getMessage = (type, key, msgs) =>
    Vars.headless
        ? ''
        : Core.bundle.format(type + "." + exports.modName + "." + key, msgs || []);
const setBuilding = function (blockType, buildingCreator) {
    blockType.buildType = prov(() => buildingCreator(blockType));
}
setBuilding(extend(Block, "next-wave",{}),(block) => extend(Building, {
    buildConfiguration(table) {
        table.button(Icon.upOpen, Styles.defaulti, run(() => {
            this.configure(0)
        })).size(50,50).tooltip("下一波");
    },
    configured(player, value) {
        switch (value) {
            case 0: {
                // Evil thing, any one can call next wave
                if (Vars.net.client()) {
                    Call.adminRequest(Vars.player, Packets.AdminAction.wave, null)
                } else {
                    Vars.state.wavetime = 0;
                }
                break;
            }
            case 1: {
                for (var i = 10; i > 0; i--) {
                    if (Vars.net.client()) {
                        Call.adminRequest(Vars.player, Packets.AdminAction.wave, null)
                        //Call.adminRequest(Vars.player, Packages.mindustry.net.Packets.AdminAction.wave,null);//老版本
                    } else {
                        Vars.logic.runWave();
                    }
                }
                break;
            }
            default: {
                // print('Unknown config event value ' + value);
            }
        }
    }
}));
