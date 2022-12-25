package jp.ac.asojuku.feprj.form;

import com.sun.istack.internal.NotNull;

import lombok.Data;

@Data
public class BattleStartForm {
	@NotNull
	private String name;
}
