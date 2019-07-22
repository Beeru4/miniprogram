Page({
  data: {
    x: 0,
    y: 0
  },
  tap: function (e) {
    this.setData({
      x: 30,
      y: 30
    });
  },
  startGame: function (e) {
    wx.redirectTo({
      url: '../game/game',
      success: function(){
        console.log("跳转页面成功");
      },fail:function(){
        console.log("跳转页面失败");
      }
    })
  },
})