<template>
  <div class="el-col-offset-6 el-col-12 absolute-position top-15">
<!--    <a href="https://www.baidu.com/" @click.prevent="aClick(this)">点我</a>-->

    <div class="text-center system-choice">
      <span>系统选择</span>
    </div>
    <div>
      <el-carousel v-if="items.length > 0" indicator-position="outside" :autoplay="false" arrow="never">
        <el-carousel-item v-if="items.length % systemLength == 0" v-for="(item, index) in carouselLength">
          <div class="el-col-6 text-center margin-bottom-20"
               v-for="(ele, idx) in systemLength">
            <a>
              <div><i class="el-icon-eleme icon-font-size-80"></i></div>
              {{items[index * systemLength + idx].systemName}}
            </a>
          </div>
        </el-carousel-item>

        <el-carousel-item v-for="(item, index) in carouselLength">
          <div v-if="index + 1 == carouselLength">
            <div class="el-col-6 text-center margin-bottom-20"
                 v-for="(ele, idx) in items.length % systemLength"
                 @click="start(index * systemLength + idx)">
              <a>
                <div><i class="el-icon-eleme icon-font-size-80"></i></div>
                {{items[index * systemLength + idx].systemName}}
              </a>
            </div>
          </div>
          <div v-else>
            <div class="el-col-6 text-center margin-bottom-20"
                 v-for="(ele, idx) in carouselLength"
                 @click="start(index * systemLength + idx)">
              <a>
                <div><i class="el-icon-eleme icon-font-size-80"></i></div>
                {{items[index * systemLength + idx].systemName}}
              </a>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>

</template>


<script>
  import {getMySystem} from '@/api/sysbase/sysbase'
  import store from "@/store";

  export default {
    name: 'System',
    data() {

      return {
        items: [],
        carouselLength: 1,
        systemLength: 8
      }
    },
    created() {
      // window.addEventListener('storage', this.afterQRScan)
      getMySystem().then(res => {
        this.items = res.data
        if (this.items.length / this.systemLength > 0) {
          this.carouselLength = Math.ceil(this.items.length / this.systemLength)
        }
        // console.log(this.items[0].systemName)
      })
    },
    mounted() {

    },
    destroyed() {
      // window.removeEventListener('storage', this.afterQRScan)
    },
    methods: {
      start(index) {
        const system = this.items[index];
        store.dispatch('user/getSystemMenu', system.systemCode)
          .then(() => {
            location.href = system.indexUrl;
            // this.$router.push('/dashboard')
          })
          .catch(err => {
            console.log(err)
            // this.loading = false
          })
      }
    }
  }
</script>

<style lang="scss">

  $bg:#283443;
  $light_gray:#fff;
  $cursor: #fff;

  @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
    .login-container .el-input input {
      color: $cursor;
    }
  }

  .margin-bottom-20 {
    margin-bottom: 20px;
  }

  .system-choice {
    font-size: 24px;
    margin: 10px;
  }

  .system-row{
    display: flex;
    align-items: center;
    width:100%;
    flex-wrap: wrap;
  }

  .system-item{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    width:25%;
    padding-top: 10px;
    padding-bottom: 10px;
  }

  .icon-font-size-80 {
    font-size: 80px;
  }

  .system-img {
    width: 80px;
    height: 80px;
    margin: 5px;
  }

  .top-15 {
    top: 15%;
  }

  .absolute-position {
    position: absolute;
    background: darkgrey;
  }

  .opacity{
    opacity: 0.4;
    background: #e5e5e5;
  }

  .sudoku_item img{
    margin-bottom: 3px;
    display: block;
  }

  /* reset element-ui css */
  .login-container {
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;

      input {
        background: transparent;
        border: 0px;
        -webkit-appearance: none;
        border-radius: 0px;
        padding: 12px 5px 12px 15px;
        color: $light_gray;
        height: 47px;
        caret-color: $cursor;

        &:-webkit-autofill {
          box-shadow: 0 0 0px 1000px $bg inset !important;
          -webkit-text-fill-color: $cursor !important;
        }
      }
    }

    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
  }
</style>

<style lang="scss" scoped>
  $bg:#2d3a4b;
  $dark_gray:#889aa4;
  $light_gray:#eee;

  .login-container {
    min-height: 100%;
    width: 100%;
    background-color: $bg;
    overflow: hidden;

    .login-form {
      position: relative;
      width: 520px;
      max-width: 100%;
      padding: 160px 35px 0;
      margin: 0 auto;
      overflow: hidden;
    }

    .tips {
      font-size: 14px;
      color: #fff;
      margin-bottom: 10px;

      span {
        &:first-of-type {
          margin-right: 16px;
        }
      }
    }

    .svg-container {
      padding: 6px 5px 6px 15px;
      color: $dark_gray;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
    }

    .title-container {
      position: relative;

      .title {
        font-size: 26px;
        color: $light_gray;
        margin: 0px auto 40px auto;
        text-align: center;
        font-weight: bold;
      }
    }

    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: $dark_gray;
      cursor: pointer;
      user-select: none;
    }

    .thirdparty-button {
      position: absolute;
      right: 0;
      bottom: 6px;
    }

    @media only screen and (max-width: 470px) {
      .thirdparty-button {
        display: none;
      }
    }
  }
</style>
