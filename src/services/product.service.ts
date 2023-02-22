import { ALERT_SUCCESS, ALERT_ERROR } from "@/plugins/interfaces";
import axios from "@/plugins/axios";
import type { Alert } from "@/plugins/interfaces";
    export const newProduct = async (
    name: string,
    price: number,
    description : string
  ): Promise<boolean | Alert> => {
    try {
      const { data } = await axios.post("", {
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
  ): Promise<boolean | Alert> => {
    try {
      const { data } = await axios.get("", {
        id
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
  ): Promise<boolean | Alert> => {
    try {
      const { data } = await axios.get("", {
        id
      });
  
      if (data.status) return true;
      else return data;
    } catch (error: any) {
        return false
    }
    return false;
  };
  export const listProduct = async (
    ): Promise<boolean | Alert> => {
      try {
        const { data } = await axios.get("");
    
        if (data.status) return data;
        else return data;
      } catch (error: any) {
          return false
      }
      return false;
    };