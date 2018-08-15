/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kasolution.funcionario.controller;

import br.com.kasolution.funcionario.dao.DaoException;
import br.com.kasolution.funcionario.dao.FuncionarioDao;
import br.com.kasolution.funcionario.modelo.Funcionario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author igordev
 */
@Controller
public class FuncionarioController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("formFuncionario")
    public String formulario() {
        return "formulario-funcionario";
    }
    
    @RequestMapping("mostraFuncionario")
    public String mostraFuncionario(int id, Model model) {
        Funcionario funcionario;
        try (FuncionarioDao dao = new FuncionarioDao()) {
            funcionario = dao.buscarId(id);
            model.addAttribute("funcionario", funcionario);
            return "formulario-funcionario";
        } catch (DaoException e) {
            System.out.println("Erro ao buscar funcionário! " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    @RequestMapping("salvaFuncionario")
    public String salva(Funcionario funcionario) {
        try (FuncionarioDao dao = new FuncionarioDao()) {
            dao.salvar(funcionario);
        } catch (DaoException e) {
            System.out.println("Erro ao gravar! " + e.getMessage());
            throw new RuntimeException(e);
        }
        return "redirect:listaFuncionario";
    }
    
    @RequestMapping("listaFuncionario")
    public String lista(Model model) {
        List<Funcionario> funcionarios;
        try (FuncionarioDao dao = new FuncionarioDao()) {
            funcionarios = dao.buscarTodos();
            model.addAttribute("funcionarios", funcionarios);
            return "lista-funcionarios";
        } catch (DaoException e) {
            System.out.println("Erro ao listar! " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    @RequestMapping("removeFuncionario")
    public String remove(Funcionario funcioario) {
        try (FuncionarioDao dao = new FuncionarioDao()) {
            dao.excluir(funcioario);
        } catch (DaoException e) {
            System.out.println("Erro ao remover! " + e.getMessage());
            throw new RuntimeException(e);
        }
        return "redirect:listaFuncionario";
    }
    
    @RequestMapping("paginaErro")
    public String erro(HttpServletRequest request) {
        return "pagina-erro";
    }
}
