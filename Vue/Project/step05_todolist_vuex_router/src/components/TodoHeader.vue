<template>
    <header>
        <img src="../assets/logo.png" />
        <h1>TODO LIST - VUEX & ROUTER</h1>
        <div>
            <router-link to="/input">TodoList 추가</router-link><br/>
            <router-link to="/list">TodoList 목록</router-link>
        </div>
    </header>
</template>

<script>
    export default {
        
    }
</script>

<style scoped>
h1{
    color: mediumpurple;
    font-weight: 900;
    margin: 2.5rem 0 1.5rem
}
</style>