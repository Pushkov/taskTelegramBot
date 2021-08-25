<template>
    <div>
        <NavigationBar/>
        <h4>CityList Page</h4>
    </div>
</template>

<script>
    import NavigationBar from "@/components/NavigationBar";
    import {mapActions} from 'vuex'

    export default {
        name: "Index",
        data() {
            return {
            }
        },
        components:{
            NavigationBar,
        },
        methods:{
            ...mapActions([
                'GET'
            ])
        }
    }
</script>

<style scoped>

</style>