

/* 
//Java核心系统
function CreatorsPackage(name) {
	var p = Packages.rhino.NativeJavaPackage(name, Vars.mods.mainLoader());
	Packages.rhino.ScriptRuntime.setObjectProtoAndParent(p, Vars.mods.scripts.scope)
	return p
}
var CreatorsJavaPackFP = CreatorsPackage('FantasyProject')
importPackage(CreatorsJavaPackFP)
importPackage(CreatorsJavaPackFP.content)

FPModJS.RunName.add("ct_fantasy_project")
FPModJS.DawnRun.add(run(() => {
	require('FP1');
})); 
*/
require('FP2');   