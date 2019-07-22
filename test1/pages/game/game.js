//game.js
var nowDidian = "";   //当前地点
var price = 0;        //当前选中的房屋的金额

var canBuyNum = 0;    //用户想要购买的房屋数量
var num = 0;          //用户能够购买的房屋数量
var typeid=0;

Page({
  data:{
    shoulouBlock:"block",
    fuwuBlock:"none",
    cangkuBlock:"none",
    lishiBlock:"none",
    nowday: 1,
    allday: 40,
    yishou:0,
    shenyu:10,
    cash:2000,
    jiekuan:2000,
    daishou:0,
    daifu:0,
    tili:100,
    renpin:100,
    buyHidden : "none",
    showModal: false,
    nowDidian : "请选择地点",
    nowTypename: "请选择房屋类型"
  },

  //售楼中心按钮
  shoulou:function(){
    this.setData({
      shoulouBlock: "block",
      fuwuBlock: "none",
      cangkuBlock: "none",
      lishiBlock: "none"
    })
  },

  //服务市场按钮
  fuwu: function () {
    this.setData({
      shoulouBlock: "none",
      fuwuBlock: "block",
      cangkuBlock: "none",
      lishiBlock: "none"
    })
  },

  //仓库按钮
  cangku: function () {
    this.setData({
      shoulouBlock: "none",
      fuwuBlock: "none",
      cangkuBlock: "block",
      lishiBlock: "none"
    })
  },

  //历史事件按钮
  lishi: function () {
    this.setData({
      shoulouBlock: "none",
      fuwuBlock: "none",
      cangkuBlock: "none",
      lishiBlock: "block"
    })
  },

  //页面打开时进行的事件
  onLoad(e) {
    this.setData({
      msgList: [
        { url: "url", title: "想要进入下一天需要自行点击呦" },
        { url: "url", title: "贷款的利息是按每天算的呦，建议尽快换完" },
        { url: "url", title: "体力值可以去按摩院回复哟，不过要收费" }]
    });
  },

  //进入下一天
  nextday: function (e) {
    console.log(e.data);
    this.setData({
      nowday: this.data.nowday + 1
    });
  },
  
  //售楼中心地点选择
  qiehuandidian : function (ev) {
    //判断用户是否重复选择了该地址
    if (ev.target.dataset.didianname == nowDidian){
      this.setData({
        error: "你已经在这里啦",
        showModal: true
      });
    }else{
      //判断体力是否够用户继续
      if (this.data.tili >= 5) {
        nowDidian = ev.target.dataset.didianname;     //记录当前地点
        var that = this;
        wx.request({
          url: 'http://172.18.88.108:8080/selectByregionGameHouse',
          data: {
            region: nowDidian
          },
          method: 'POST',
          header: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          success: function (res) {
            console.log(res.data);
            that.setData({
              tili: that.data.tili - 5,
              nowHourse: res.data,
              buyHidden: "none",
              nowType: "",
              nowDidian: nowDidian
            })
          }
        })
        
      } else {
        this.setData({
          error: "你没有体力值了哟",
          showModal: true
        });
      }
    }
  },

  //选中房屋后显示给用户购买房屋块
  xuanzhongfang : function(e){
    price=e.target.dataset.price;
    typeid = e.target.dataset.typeid;
    this.setData({
      buyHidden : "block",
      nowTypename: e.target.dataset.typename,
      num:0
    });
  },

  //判断用户输入的房屋数量
  querenHourseNum : function(e){
    //最多可购买数量
    canBuyNum = parseInt(this.data.cash / price);
    num = e.detail.value;
    if (e.detail.value == "" || e.detail.value == 0) {
      this.setData({
        error: "请输入购买数量",
        num : 0,
        showModal: true
      });
    } else if (e.detail.value < canBuyNum && e.detail.value < 0) {
      this.setData({
        error: "请输入正确的数量",
        num: 0,
        showModal: true
      });
    } else if (e.detail.value <= canBuyNum ) {
    } else if (e.detail.value > canBuyNum) {
      this.setData({
        error: "你买不起那么多，最多购买" + canBuyNum,
        num: canBuyNum,
        showModal: true
      });
    }else{
      this.setData({
        error: "请输入数字类型",
        num: 0,
        showModal: true
      });
    }
  },

  //用户确定购买房屋
  buyHourse : function(e){
    if (num == "" || num == 0) {
      this.setData({
        error: "请输入购买数量",
        num: 0,
        showModal: true
      });
      num = 0;
    } else if (num < canBuyNum && num < 0) {
      this.setData({
        error: "请输入正确的数量",
        num: 0,
        showModal: true
      });
      num = 0;
    } else if (num <= canBuyNum) {
      var that=this;
      wx.request({
        url: 'http://172.18.88.108:8080/addHouse',
        data: {
          houseMy: {
            userId:1,
            houseId: that.data.nowHourse[typeid-1],
            buyPrice: that.data.nowHourse[typeid - 1].price,
            sellPrice:0,
            zhuangxiu:0,
            mensuo:0,
            yangan:0,
            dianbiao:0,
            shuibiao:0,
            jiaozuri: that.data.nowday,
            shouzuri:0,
            yizu:0
          },
          num: num
        },
        method: 'POST',
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        success: function (res) {
          that.setData({
            num: 0,
            error: res.data,
            showModal: true,
            cash: that.data.cash - (num * price),
            shenyu: parseInt(that.data.shenyu) + parseInt(num)
          })
        }
      })
      
     
      
      num = 0;
    } else if (num > canBuyNum) {
      this.setData({
        error: "你买不起那么多，最多购买" + canBuyNum,
        num: canBuyNum,
        showModal: true
      });
      num = canBuyNum;
    } else {
      this.setData({
        error: "请输入数字类型",
        num: 0,
        showModal: true
      });
      num = 0;
    }
  },

  //隐藏模态窗
  hideModal: function () {
    this.setData({
      showModal: false
    });
  },

  //用户点击模态窗取消
  onCancel: function () {
    this.hideModal();
  },

  //用户点击模态窗确定
  onConfirm: function () {
    this.hideModal();
  }

})