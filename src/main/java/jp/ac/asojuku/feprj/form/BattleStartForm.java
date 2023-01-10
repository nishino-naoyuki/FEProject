package jp.ac.asojuku.feprj.form;


import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BattleStartForm {
	@NotNull
	private String name;
}
