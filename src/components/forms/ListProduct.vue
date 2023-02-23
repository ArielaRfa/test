<script setup lang="ts">
    import { ref } from "vue";
    import * as NewProduct from './NewProduct.vue'
    import {listProduct} from "../../services/product.service"
    import {onMounted} from 'vue'
    const showList = ref(true);
    const showNew = ref(false);
    const onNew = () : void => {
        showList.value = true;
        showNew.value = true;
        
    }
    onMounted(()=>{
        listProduct().then(result=>{(console.log("tony ny resultat",result))});
    })
</script>
<template>
    <div class="container-fluid" v-if="showList">
        <button class="btn btn-primary" @click="onNew">Nouveau produit</button>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Description</th>
                </tr>
            </thead>
            <tbody>
                <tr></tr>
            </tbody>
        </table>
    </div>
    <NewProduct v-if="showNew"></NewProduct>
</template>