const base = {
    get() {
        return {
            url : "http://localhost:8080/ziyaunfuwuguanli/",
            name: "ziyaunfuwuguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ziyaunfuwuguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "志愿服务管理系统"
        } 
    }
}
export default base
