package org.thales.hublafullstack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thales.hublafullstack.domain.transaction.Transaction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

//    @GetMapping("/")
//    public String listUploadedFiles(Model model) throws IOException {
//
//        model.addAttribute("files", storageService.loadAll().map(
//                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//                                "serveFile", path.getFileName().toString()).build().toUri().toString())
//                .collect(Collectors.toList()));
//
//        return "uploadForm";
//    }

    @PutMapping("/")
    public void get(@RequestParam("file") MultipartFile file) throws Exception {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8).trim();

        String[] rows = content.split("\n");

        ArrayList<Transaction> transacoes = new ArrayList<>();

        for (String row :
                rows) {
            transacoes.add(Transaction.of(row));
        }

        transacoes.stream().collect(
                Collectors.groupingBy(transaction -> transaction.getProduct().getValue(),
                        Collectors.groupingBy(transaction -> transaction.getSeller().getValue(),
                                Collectors.groupingBy(transaction -> transaction.getTransactionType().getType())
                        )
                )
        );
    }

    @PostMapping("/")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8).trim();

        String[] rows = content.split("\n");

        String tipo = rows[0].trim().substring(0, 1);
        String data = rows[0].trim().substring(1, 26);
        String produto = rows[0].trim().substring(26, 56).trim();
        String valor = rows[0].trim().substring(56, 66);
        String vendedor = rows[0].trim().substring(66, rows[0].length());

        System.out.println("show");
    }

//        @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }

}