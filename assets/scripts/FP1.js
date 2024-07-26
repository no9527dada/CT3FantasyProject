FantasyProjectWuLiu.动能卸货器.health = 999;
const UnloaderBuild = Unloader.UnloaderBuild;
const speed = FantasyProjectWuLiu.动能卸货器.speed;
const limit = 30 / speed;
FantasyProjectWuLiu.动能卸货器.buildType = () => {
    let counter = 0;
    return extend(UnloaderBuild, FantasyProjectWuLiu.动能卸货器, {
        updateTile() {
            counter += this.edelta();

            while (counter >= limit) {
                this.unloadTimer = speed;

                this.super$updateTile();

                counter -= limit;
            }
        },

    });;
}


