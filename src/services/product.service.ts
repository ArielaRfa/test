//import { ALERT_SUCCESS, ALERT_ERROR } from "@/plugins/interfaces";
//import axios from "@/plugins/axios";
import axios from 'axios';
//import VueAxios from 'vue-axios';
//import type { Alert } from "@/plugins/interfaces";
import * as Vue from 'vue' // in Vue 3
//import axios from 'axios'
import VueAxios from 'vue-axios'
    export const newProduct = async (
    name: string,
    price: string,
    description : string
  ): Promise<boolean> => {
    try {
      const { data } = await axios.post("localhost:8080/produits", {
        name,
        price,
        description
      });
  
      if (data.status) return true;
      else return data;
    } catch (error: any) {
        return false
    }
    return false;
  };
  export const updateProduct = async (
    id: number
  ): Promise<boolean> => {
    try {
      const { data } = await axios.get("localhost:8080/produits", {data:{id}
        
      });
  
      if (data.status) return true;
      else return data;
    } catch (error: any) {
        return false
    }
    return false;
  };
  export const deleteProduct = async (
    id: number
  ): Promise<boolean> => {
    try {
      const { data } = await axios.get("localhost:8080/produits", {data:{id}
        
      });
  
      if (data.status) return true;
      else return data;
    } catch (error: any) {
        return false
    }
    return false;
  };
  export const listProduct = async (
    ): Promise<boolean> => {
      try {
        
        const { data } = await axios.get('localhost:8080/produits');
        console.log("fjqjfs");
        console.log("ty ny data",data);
        if (data.status) 
          return data;
        else
           return false;
      } catch (error: any) {
          return false;
      }
      return false;
      
    };