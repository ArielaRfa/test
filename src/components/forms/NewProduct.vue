<script lang="ts">
    import { ref } from "vue";
    import {newProduct} from "../../services/product.service"
    //import commonjs from 'rollup-plugin-commonjs'
    //v-model="description"
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
                class="form-control"
                placeholder="Name"
            >
        </div>
        <div class="mb-3">
            <input
                
                class="form-control"
                placeholder="Price"
            >
        </div>
        <div class="mb-3">
            <input
                
                class="form-control"
                placeholder="Description"
            >
        </div>
        <div class="position-absolute mt-5 start-50 translate-middle">
            <button class="btn btn-primary">Enregistrer  @click="addNewProduct"</button>
        </div>
    </form>
</template>