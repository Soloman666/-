<template>
   <div>
    <div class="demo-image" style="text-align:center">
  <div class="block" :key="fill">
    <span class="demonstration">{{ fill }}</span>
    <el-image
      style="width: 500px; height: 500px"
      :src="url"
      :fit="fit"></el-image>
  </div>
</div>
</div>
</template>

<script>
export default {
    data() {
      return {
        fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
        url: 'https://img2.baidu.com/it/u=2348876678,2704455439&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500'
      }
    }
    
}
</script>

<style>

</style>