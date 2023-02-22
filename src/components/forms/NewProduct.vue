<script lang="ts">
    import { ref } from "vue";
    import {newProduct} from "../services/product.service"
    const name = ref("");
    const price = ref("");
    const description = ref("");

    const addNewProduct = () : void => {
        newProduct(name.value,price.value,description.value).then( () => {
            
        });
    };
</script>
<template>
    <form>
        <div class="mb-3">
            <input
                v-model="name"
                class="form-control"
                placeholder="Name"
            >
        </div>
        <div class="mb-3">
            <input
                v-model="price"
                class="form-control"
                placeholder="Price"
            >
        </div>
        <div class="mb-3">
            <input
                v-model="description"
                class="form-control"
                placeholder="Description"
            >
        </div>
        <div class="position-absolute mt-5 start-50 translate-middle">
            <button class="btn btn-primary" @click="addNewProduct">Enregistrer</button>
        </div>
    </form>
</template>