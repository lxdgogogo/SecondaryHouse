<template>
<div id="container">
  1

</div>
</template>

<script>
import loadBMap from '/src/store/loadBap';
export default {
  name: "mapTemp",
  data() {
    return {
      Location: ""
    }
  },
  created() {
    let Location = this.$route.query.loc
    let that =  this
    loadBMap().then(_ => {
      that.BMap = _
      this.mapTemp = new this.BMap.Map("container"); // 创建地图实例
      that.mapTemp.centerAndZoom(Location, 15); // 根据名字定位地图中心点
      that.mapTemp.enableScrollWheelZoom(); // 开启鼠标滑动缩放地图
      var localSearch = new this.BMap.LocalSearch(this.mapTemp);
      localSearch.enableAutoViewport(); //允许自动调节窗体大小
      localSearch.setSearchCompleteCallback(function (searchResult){
        var poi = searchResult.getPoi(0).point;
        var mkr =new that.BMap.Marker(poi);
        that.mapTemp.addOverlay(mkr)
      })
      localSearch.search(Location)
    })


  }
}
</script>

<style scoped>
#container {
  height: 100vh;
  width: 100%;
}
</style>