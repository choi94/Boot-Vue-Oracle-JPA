<template>
<div>

    <input @click="$store.commit('increment')" type="button" value="도출!">
    <div>
    {{ $store.state.email }}
    </div>
</div>
</template>
<script>
export default {
    
}
</script>
<style scoped>

</style>


