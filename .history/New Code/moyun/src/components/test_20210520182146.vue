<template>
  <div class="">
    <el-scrollbar class="scrollbar-wrapper">
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
      >
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>导航一</span>
          </template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <template slot="title">选项4</template>
            <el-menu-item index="1-4-1">选项1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <span slot="title">导航二</span>
        </el-menu-item>
        <el-menu-item
          index="3"
          disabled
        >
          <i class="el-icon-document"></i>
          <span slot="title">导航三</span>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
 
        <el-menu-item index="5">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
 
        <el-menu-item index="6">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
 
        <el-menu-item index="7">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
 
        <el-menu-item index="8">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
 
        <el-menu-item index="9">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
 
        <el-menu-item index="10">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
 
        <el-menu-item index="11">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
 
        <el-menu-item index="12">
          <i class="el-icon-setting"></i>
          <span slot="title">导航12</span>
        </el-menu-item>
      </el-menu>
    </el-scrollbar>
  </div>
</template>
 
<script type="text/ecmascript-6">
export default {
  data() {
    return {}
  },
  components: {},
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath)
    }
  },
  computed: {}
}

————————————————
版权声明：本文为CSDN博主「踏 浪」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u010559460/article/details/105094931