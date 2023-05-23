package com.example.springwebfluxsample.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@Builder
@RequiredArgsConstructor
@Schema(description = "todoデータ")
public class Todo {
  @NonNull
  @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "ID", example = "123")
  Integer id;
  @NonNull
  @Schema(requiredMode = Schema.RequiredMode.AUTO, title = "nameのtitle要素", description = """
      todoの名前<br>
      改行して表示できるかの確認
      """, example = "名前")
  String name;
}
