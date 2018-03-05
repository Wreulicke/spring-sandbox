/**
 * MIT License
 *
 * Copyright (c) 2017 Wreulicke
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.wreulicke.simple.user;

import java.util.Collections;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@ToString(exclude = "password")
@EqualsAndHashCode
@Getter
public class CreateUserRequest {

  @NonNull
  @NotEmpty
  private final String username;
  
  @NonNull
  @NotEmpty
  private final String password;
  
  @NonNull
  @Size(min = 1)
  private final Set<String> authorities;
  
  public CreateUserRequest(@NonNull String username, @NonNull String password) {
    this.username = username;
    this.password = password;
    this.authorities = Collections.singleton("USER");
  }
  
  @JsonCreator(mode = JsonCreator.Mode.DEFAULT)
  public CreateUserRequest(@NonNull String username, @NonNull String password, @NonNull Set<String> authorities) {
    this.username = username;
    this.password = password;
    this.authorities = authorities;
  }

}
