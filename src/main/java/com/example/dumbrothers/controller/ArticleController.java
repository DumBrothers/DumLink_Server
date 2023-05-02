package com.example.dumbrothers.controller;

import com.example.dumbrothers.dto.ArticleForm;
import com.example.dumbrothers.entity.Article;
import com.example.dumbrothers.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {

    @Autowired//스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
       log.info(form.toString());
        // System.out.println(form.toString()); ->로깅 기능으로 대체
        //
        // 1.dto를 변환 entity로 !
        Article article = form.toEntity();
       log.info(article.toString());
        // System.out.println(article.toString());


        // 2.repository에게 entity를 db안에 저장하게 함 !
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        System.out.println(saved.toString());

        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id= "+id);

        // 1: id로 데이터를 가져옴
        Article articleEntity=articleRepository.findById(id).orElse(null);

        // 2: 가져온 데이터를 모델에 등록
        model.addAttribute("article",articleEntity);

        // 3: 보여줄 페이지를 설정!

        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model){
        //1 모든 article을 가져온다
        List<Article> articleEntityList=articleRepository.findAll();

        //2 가져온 article 묶음을 뷰로 전달
        model.addAttribute("articleList",articleEntityList);
        //3 뷰 페이지를 설정
        return "articles/index";
    }


}
