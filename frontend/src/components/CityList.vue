<template class=" mt-xl-5">
    <div class="w-75 m-auto">

        <CityModal
                v-if="isModal"
                :popup-title="getCityModalTitle"
                :is-edit="isModalEdit"
                @closeUserModal="closeCityModal"
        >
            <CityViewModal
                    ref="engineerView"
                    :item="currentCity"
                    :is-edit="isModalEdit"
                    @returnUser='returnCity'
            />
            <CityFooterModel
                    slot="footer"
                    @modalClose="closeCityModal"
                    @saveItem='saveCity'
                    @deleteItem="deleteCity"
                    @editItem="editCity"
                    :is-edit="isModalEdit"
                    :is-create="isModalCreate"
            />
        </CityModal>


        <div v-if="3 > 0">
            <div class="text-left my-3">
                <b-button @click="createCity" class="mr-1"><h5 class="m-auto">Добавить город</h5></b-button>
                <b-button class="mr-1"><h5 class="m-auto">Добавить место</h5></b-button>
            </div>

            <table class="table table-hover table-bordered table-striped">
                <thead class="thead-light">
                <tr>
                    <th>Название</th>
                    <th>Рекомендовано</th>
                    <th>Не заслуживает внимания</th>
                </tr>
                </thead>
                <tbody>
                <CitiesTableRow
                        v-for="city of CITIES"
                        :city="city"
                        :key="city.id"
                        @getCityModal = "showCityModal(city)"
                />
                </tbody>
            </table>
        </div>
        <div v-else>
            <h3>ERROR_LIST_LOAIDNG_MESSAGE</h3>
        </div>
    </div>
</template>


<script>
    import {mapGetters, mapActions} from 'vuex'
    import CitiesTableRow from "./CitiesTableRow";
    import CityModal from "./modals/CityModal";
    import CityViewModal from "./modals/CityViewModal";
    import CityFooterModel from "./modals/CityFooterModal";
    export default {
        name: "CityList",
        data() {
            return {
                currentCity:{},
                isModal: false,
                isModalEdit: false,
                isModalCreate: false
            }
        },
        components: {
            CityFooterModel,
            CityViewModal,
            CityModal,
            CitiesTableRow
        },
        computed: {
            ...mapGetters([
                'CITIES',
                'ERROR_LIST_LOAIDNG_MESSAGE'
            ]),
            getCityModalTitle() {
                return this.isModalCreate
                    ? 'Создать запись о новом городе'
                    : 'Информация о городе';
            }
        },
        methods: {
            ...mapActions([
                'GET_ALL_CITIES'
            ]),
            showCityModal(city) {
                this.isModalCreate = false;
                this.isModal = true;
                this.isModalEdit = false;
                this.currentCity = city;
            },
            closeCityModal() {
                this.isModal = false;
                this.isModalEdit = false;
                this.isModalCreate = false;
            },
            returnCity(city) {
                this.currentCity = city;
            },
            createCity(){
                this.isModalCreate = true;
                this.isModal = true;
                this.isModalEdit = true;
                this.currentCity = {};
            },
            saveCity(){
                this.closeCityModal();
            },
            deleteCity() {
                this.closeCityModal();
            },
            editCity(city) {
                console.log(city)
                this.isModalEdit = true;
            }

        },
        mounted() {
            this.GET_ALL_CITIES();
        }
    }
</script>

<style scoped>

</style>