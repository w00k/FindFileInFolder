/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findfileinfolder;

import java.io.File;
import java.util.List;

/**
 *
 * @author wook82
 */
public class FindFile {
    
    private List<String> listFiles;

    public List<String> getListFiles() {
        return listFiles;
    }

    public void setListFiles(List<String> listFiles) {
        this.listFiles = listFiles;
    }
    
    public void findFile(String name,File file) {
        
        File[] list = file.listFiles();
        
        if(list!=null){
            for (File fil : list) {     
                //busqueda en subcarpetas
                if (fil.isDirectory()) {
                    findFile(name,fil);
                } else 
                    if (name.equalsIgnoreCase(fil.getName())) {
                        System.out.println(" copy ---> " + fil.getAbsolutePath());
                        break ; 
                    } 
            }
        } else {
            System.out.println(" lista nula ... ");
        }
 
    }
    
    public void findFile(String name,File file, boolean subfolder) {
        
        File[] list = file.listFiles();
        
        if(list!=null){
            for (File fil : list) {     
                //busqueda en subcarpetas
                if (fil.isDirectory() && subfolder == true) {
                    findFile(name,fil, subfolder);
                } else 
                    if (name.equalsIgnoreCase(fil.getName())) {
                        System.out.println(" copy ---> " + fil.getAbsolutePath());
                        break ; 
                    } 
            }
        } else {
            System.out.println(" lista nula ... ");
        }
 
    }
    
}
