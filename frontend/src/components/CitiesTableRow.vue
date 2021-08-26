<template>
    <tr>
        <td @click="showCityModal">
            <h3>{{city.name}}</h3>
        </td>
        <td>
            <div v-if="getFilteredPlaces('GOOD').length !== 0 ">
                <ul v-for="place of getFilteredPlaces('GOOD')"
                    :key="place.id"
                >
                    <PlaceTableRow :place="place"/>
                </ul>
            </div>
            <div v-else>
                <h5>-</h5>
            </div>
        </td>
        <td>
            <div v-if="getFilteredPlaces('BAD').length !== 0 ">
                <p v-for="place of getFilteredPlaces('BAD')"
                   :key="place.id"
                >
                    <PlaceTableRow :place="place"/>
                </p>
            </div>
            <div v-else>
                <h5>-</h5>
            </div>
        </td>
    </tr>

</template>

<script>
    import PlaceTableRow from "./PlaceTableRow";

    export default {
        name: "CityTableRow",
        props: {
            city: {
                type: Object,
                default: () => {
                    return {}
                }
            }
        },
        components: {
            PlaceTableRow
        },
        computed: {

        },
        methods: {
            showCityModal() {
                this.$emit('getCityModal', this.city);
            },
            getFilteredPlaces(grade) {
                return this.city.places.filter(function (e) {
                    return e.grade === grade;
                });
            }
        },
    }
</script>

<style scoped>

</style>